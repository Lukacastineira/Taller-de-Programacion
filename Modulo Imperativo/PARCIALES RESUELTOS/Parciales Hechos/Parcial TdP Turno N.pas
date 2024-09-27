
program Castineira;


type
       meses = 1..12;  rangoDiagnostico = 1..5;
       atencion  = record
             matricula:integer;      // FIN MATRICULA 0
             dni:integer;
             mes:meses;
             diagnostico:rangoDiagnostico
        end;
        
           atencionA  = record
             matricula:integer;      
             dni:integer;
             diagnostico:rangoDiagnostico
        end;
       
       arbol = ^nodoArbol;
       nodoArbol = record
           dato:atencionA;
           HI:arbol;
           HD:arbol;
       end;     
  
       vecAtenciones = array [meses] of arbol; 
       
       procedure leerAtencion (var a:atencion);
       begin
             a.matricula := Random (100);
             if (a.matricula <> 0) then
             begin
                   a.dni := Random (100) +1;
                   a.mes:= Random(12) + 1;
                   a.diagnostico :=  (5);
             end;
       end;
       
       procedure inicializarV (var v:vecAtenciones);
       var i:integer;
       begin
            for i:= 1 to 12 do
            begin
                 v[i] := nil;
            end;
       end;
       
       procedure  agregarA ( var a:arbol; at:atencionA);
       begin
            if (a= nil) then
            begin
                 new (a); a^.dato:=at; a^.HI:=nil; a^.HD:=nil;
            end
            else if (at.dni < a^.dato.dni) then  agregarA (a^.HI,at)
            else  agregarA (a^.HD,at);
       end;
       
       procedure  pasarA (var a:atencionA; dni:integer; diagnostico:rangoDiagnostico; matricula:integer);
       begin
             a.dni:=dni;
             a.diagnostico:= diagnostico;
             a.matricula:=matricula;
       end;
       
       procedure   cargarEstructuras (var v:vecAtenciones);
       var   a:atencionA; at:atencion;
       begin
             leerAtencion(at);
             while (at.matricula <> 0) do
             begin
                   pasarA (a,at.dni,at.diagnostico, at.matricula);
                   agregarA (v[at.mes],a);
                   leerAtencion (at);
             end;
       end;
       
      function  contarA (a:arbol): integer;
      begin
             if (a= nil) then contarA:= 0
             else 
             begin
                   contarA:= 1 + contarA (a^.HI) + contarA (a^.HD)
             end;
      end;
      
       function   incisoB (v:vecAtenciones) :integer;
       var max:integer; i:integer;
       begin
              max:=0; 
              for i:= 1 to 12 do
              begin
                    if (max < contarA (v[i])) then
                    begin
                          max:=contarA(v[i]);
                          incisoB:=i;
                    end;
                                     
              end;
       end;
       
       procedure  incisoB2punto0 (v:vecAtenciones; i:integer;  var maxCant:integer; var maxMes:integer);
       begin
            if (i <> 0 ) then 
            begin
                   incisoB2punto0 (v,i-1,maxCant,maxMes);
                   if (contarA (v[i]) > maxCant) then
                   begin
                        maxCant:= contarA (v[i]);
                        maxMes:=i;
                   end;
            end;
       end;
       
       function  encontrar  (a:arbol; dni:integer): boolean;
       begin 
             if ( a = nil) then encontrar:= false
             else if (dni = a^.dato.dni) then  encontrar:= true
             else if (dni < a^.dato.dni) then encontrar := encontrar (a^.HI,dni)
             else encontrar := encontrar (a^.HD,dni);
       end;
       
       function  incisoC ( v:vecAtenciones; dni:integer): boolean;
       var i :integer; 
       begin
            incisoC := false; i:=1;
            while ( i <= 12) and (not incisoC) do
            begin
                  incisoC := encontrar(v[i] , dni); 
                  i:= i + 1;            
            end;
       end;
       
       procedure  imprimirA (a:arbol);
       begin
            if (a <> nil) then
            begin
                     imprimirA (a^.HI);
                     writeln ('DNI: ', a^.dato.dni);
                     writeln (' Diagonstico: ', a^.dato.diagnostico);
                     writeln (' Matricula: ', a^.dato.matricula);
                     imprimirA (a^.HD);
            end;
       end;
       
       procedure imprimirV (v:vecAtenciones);
       var i:integer;
       begin
            for i:= 1 to 12 do
            begin
                  writeln ('|---------------------|');
                  writeln ('Mes: ', i);
                  writeln ('|---------------------|');
                  imprimirA(v[i]); 
            end;
       end;
       var  v:vecAtenciones; B:integer; dni:integer; encontre:boolean;   maxC: integer; i:integer; maxM:integer;
       begin
              i:= 12;
              maxC:= -1;
              maxM:= 0;
             randomize;
             inicializarV (v);
             cargarEstructuras (v); 
             imprimirV (v);
             B:= incisoB (v);
             writeln ( 'El mes con mas atenciones es: ', B);
             incisoB2punto0 (v,i,maxC,maxM);
             writeln (maxM);
             readln (dni);
             encontre:= incisoC (v,dni);
             writeln (encontre);
      end.
       
       
       
