program Castineira;

type 
     dias = 1..31;  rangoDiagnostico = 1..6;
     atencion = record
          matricula:integer;   // FIN DR 0
          dni:integer;
          dia:dias;
          diagnostico: rangoDiagnostico;
     end;
       
     atencionA = record
          matricula:integer;
          cant:integer;
     end;
     
     arbol = ^nodoArbol;
     nodoArbol = record 
          dato:atencionA;
          HI:arbol;
          HD:arbol;
     end;
     
     atencionL = record
          matricula:integer;   
          dni:integer;
          dia:dias;
     end;
     
     lista = ^nodoLista;
     nodoLista = record
        dato:atencionL;
        sig:lista;
     end;
     
     vecDiagnosticos = array [rangoDiagnostico] of  lista;
     
     
     procedure leerAtencion  (var a:atencion);
     begin
            a.matricula := Random (100);
            if (a.matricula <> 0) then
            begin
                 a.dni:= Random (100) + 1;
                 a.dia := Random (31) + 1;
                 a.diagnostico:= Random (6)+1;
            end;
     end;
     
     procedure inicializarV (var v:vecDiagnosticos); 
     var i:integer;
     begin
            for i:= 1 to 6 do
            begin
                  v[i]:=nil;
            end;
     end;
      
     procedure agregarAdelante  (var l:lista; a:atencionL);
     var nue:lista;
     begin
           new (nue); nue^.dato:=a; nue^.sig:=l; l:=nue;
     end;
     
     procedure   agregarArbol (var a:arbol; matricula:integer);
     begin
           if ( a = nil) then 
           begin
                 new (a);  a^.dato.matricula:= matricula; a^.dato.cant:= 1; a^.HD:=nil; a^.HI:=nil;
           end
           else if (matricula = a^.dato.matricula ) then a^.dato.cant := a^.dato.cant + 1
           else if (matricula < a^.dato.matricula) then agregarArbol (a^.HI,matricula)
           else  agregarArbol (a^.HD,matricula);
     end;
     
     procedure  pasarD (var a:atencionL; matricula:integer; dni:integer; dia:dias);
     begin
          a.matricula:=matricula;
          a.dni:=dni;
          a.dia:=dia;
     end;
     
     procedure cargarEstructuras (var a:arbol; var v:vecDiagnosticos);
     var   at:atencion;  aL:atencionL;
     begin
          leerAtencion (at); 
          while  (at.matricula <> 0) do
          begin
                agregarArbol (a,at.matricula);
                pasarD (aL,at.matricula,at.dni,at.dia);
                agregarAdelante (v[at.diagnostico], aL);
                leerAtencion (at);       
          end;  
     end;
     
     function  incisoB  (a:arbol; matricula:integer):integer;
     begin
          if (a = nil ) then incisoB := 0
          else if (matricula < a^.dato.matricula) then incisoB := a^.dato.cant + incisoB (a^.HI,matricula) +  incisoB (a^.HD,matricula) 
          else if (matricula >=  a^.dato.matricula) then incisoB:= incisoB (a^.HD,matricula);
     end;
     
     function  contarA (l:lista) :integer;
     var  aux:lista;
     begin
           aux:=l; contarA := 0;
           while  (aux <> nil) do
           begin 
                   contarA := contarA + 1;
                   aux:= aux^.sig;
           end;
     end;
     
     procedure   incisoC  (v:vecDiagnosticos; i:integer; var max,maxD:integer) ;
     begin
         if (i <> 0) then
          begin
                 if  (contarA(v[i]) > max) then
                 begin
                       max := contarA (v[i]);
                       maxD := i;
                 end;
                 incisoC (v,i-1,max,maxD);
          end;
     end;
     
     var a:arbol;  v:vecDiagnosticos;  matricula,B:integer;  i,max,maxD:integer;
     begin
          randomize;
          i:=6; max:=0; maxD:=0;
          inicializarV (v);
          a:=nil;
          cargarEstructuras (a,v);
          readln (matricula);
          B:=incisoB (a,matricula);
           writeln (B);
          incisoC (v,i,max,maxD);
          writeln (maxD);
     end.
     
     
     
     
     
     
     
     
     
