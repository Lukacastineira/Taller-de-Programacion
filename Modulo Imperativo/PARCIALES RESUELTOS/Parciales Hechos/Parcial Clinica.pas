{

   
}


program castineira;

type  
    rangoMes = 0..12;  rangoDiagnostico = 1..15;
    atencion = record 
         dni:integer;
         mes:rangoMes;   // fin mes 0
         diagnostico: rangoDiagnostico;
    end;
    
    atencionA = record
       cant:integer;
       dni:integer;
    end;
   
    
    arbol= ^nodo1;
    nodo1 = record
        dato:atencionA;
         HD:arbol;
         HI:arbol;
    end;
    
    vecAtenciones = array  [rangoDiagnostico] of integer;
    
    procedure   leerAtencion  (var a:atencion);
    begin
        a.mes:=Random (13);
        if (a.mes <> 0) then
        begin
            a.dni := Random (500)+ 1;
            a.diagnostico:= Random (15)+1;
        end;
    end;     
    
    procedure  inicializarV	(var v:vecAtenciones);
    var i:integer;
    begin
       for i:= 1 to 15 do
       begin
           v[i] := 0;
       end;
     end;
     
     procedure inicializarA (var a:arbol);
     begin 
           a:=nil;
     end;
     
     
     procedure  insertarArbol  (var ar:arbol; a:atencion);
     var   aA:atencionA;
     begin
          if  ( ar = nil) then
          begin
               aA.cant:=1;
               aA.dni:=a.dni;
               new (ar); ar^.dato:= aA;
               ar^.HI:=nil; ar^.HD:=nil; 
          end
          else  if (a.dni = ar^.dato.dni) then   ar^.dato.cant:= ar^.dato.cant + 1
          else if (a.dni  < ar^.dato.dni) then  insertarArbol (ar^.HI, a)
          else    insertarArbol (ar^.HD, a);
     end;
     
     procedure  cargarEstructuras   (var ar:arbol; var  v:vecAtenciones);
     var    a:atencion;
     begin
            leerAtencion (a);
            while (a.mes <> 0) do
            begin
                  v[a.diagnostico] :=  v[a.diagnostico]  + 1;
                  insertarArbol (ar,a);
                  leerAtencion(a);
             end;
     end;
            
     
     function incisoB  (a:arbol; dni1,dni2,x:integer): integer;
     begin
           if (a=nil) then incisoB := 0
           else if (dni1 < a^.dato.dni) and (dni2 > a^.dato.dni) then
             begin
                    if ( x <  a^.dato.cant) then
                           incisoB:= 1 + incisoB(a^.HI,dni1,dni2,x) + incisoB(a^.HD,dni1,dni2,x)
             end
             else if (dni1 > a^.dato.dni) then incisoB := incisoB(a^.HD,dni1,dni2,x)
             else  incisoB:= incisoB(a^.HI,dni1,dni2,x)
     end;
     
     function  incisoC  (v:vecAtenciones; i:integer):integer;
     begin
          if   (i<=15) and ( v[i] <> 0) then  incisoC :=  incisoC ( v, i +1)
          else if (i<=15) and  (v[i] = 0)  then  incisoC:= 1 + incisoC (v,i+1);
      end;
     
     var    a:arbol;  v:vecAtenciones;  dni1,dni2,x,cantB:integer;  i,cantC:integer;
     
     
     procedure  imprimirA (a:arbol);
     begin
            if (a <> nil) then
              begin
                     imprimirA (a^.HI);
                      writeln('----------------------------------------');
                       writeln('El DNI de atencion es: ',a^.dato.dni);
                       writeln(' La cantidad de atenciones de este dni es: ',a^.dato.cant);
                       writeln('----------------------------------------');
                       imprimirA (a^.HD);
                end;
       end;
       
       procedure imprimirV (v:vecAtenciones) ;
       var i :integer;
       begin 
          for i:=1 to 15 do
          begin
                writeln('La cantidad de atenciones en el diagnostico: ', i, ' es: ', v[i]);
          end;
         end;       
     begin
            randomize;
            inicializarA(a);
            inicializarV(v);
            cargarEstructuras (a,v);
            imprimirA(a);
             imprimirV(v); 
            writeln (' Ingrese DNI 1: ');
            readln (dni1);
            writeln (' Ingrese DNI 2 (mayor a DNI 1): ');
            readln (dni2);
            writeln (' Ingrese cantidad de Atenciones a superar: ');
            readln(x);
            cantB := incisoB(a,dni1,dni2,x);       
             writeln (' La cantidad de pacientes con mas de: ', x , ' atenciones es: ', cantB);  
            i:=1;
            cantC:= incisoC (v,i);
            writeln (' La cantida de diagnositcos para los cuales la cantidad  de atenciones fue cero es: ' , cantC);
            
     
     end.
    
    
    
