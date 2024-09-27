


program Castineira;

type 
       meses=1..12;
        alquiler  = record
            dni:integer;
            patente:integer;         // FIN PATENTE 0 
            mes:meses;
            anio:integer;
        end;
        
        alquilerL = record
               dni:integer;
               mes:meses;
               anio:integer;
        end;
        
        lista = ^nodo;
        nodo = record
            dato:alquilerL;
            sig:lista;
        end;
        
        alquilerA = record
             list:lista;
             patente:integer;
        end;
        
        arbol = ^nodoArbol;
        nodoArbol = record
             dato: alquilerA;
             HI:arbol;
             HD:arbol;
        end;
        
        procedure  leerAlquiler  (var a:alquiler);
        begin
               a.patente := Random (700);
               if (a.patente <> 0) then
               begin
                   a.dni:= Random (100-10)+10;
                   a.mes:= Random (12) + 1;
                   a.anio:= Random (2024-1990) + 1990;
               end;
       end;
       
       procedure agregarAdelante  (var l:lista;  a:alquilerL);
       var  nue:lista;
       begin 
             new (nue); nue^.dato:= a; nue^.sig:= l;  l:= nue;
       end;
       
       procedure pasarP   (var a:alquilerL;  dni,anio:integer; mes:meses);
       begin
              a.dni:=dni;
              a.anio:=anio;
              a.mes:= mes;
       end;
       
       procedure  agregarAlArbol  (var ar:arbol;  patente:integer;   a:alquilerL);
       begin
             if (ar = nil) then
             begin
                   new (ar); ar^.dato.patente:= patente; ar^.dato.list:=nil;
                   agregarAdelante (ar^.dato.list,a);
                   ar^.HI := nil; ar^.HD:= nil;
             end
             else if (patente = ar^.dato.patente) then  agregarAdelante (ar^.dato.list,a)
             else if (patente < ar^.dato.patente) then  agregarAlArbol (ar^.HI,patente,a)
             else   agregarAlArbol (ar^.HD,patente,a);
      end;
      
      procedure cargarEstructura   (var ar:arbol); 
      var   a:alquiler; aL:alquilerL; 
      begin
            leerAlquiler (a);
            while (a.patente <> 0 ) do
            begin 
                 pasarP (aL,a.dni,a.anio,a.mes); 
                 agregarAlArbol (ar,a.patente,aL);
                 leerAlquiler (a);
            end;
      end;
             
             
      function   contarB   (l:lista; dni:integer) : integer;
      var  aux:lista;
      begin
            aux:=l; contarB:=0;
            while  (aux <> nil) do
            begin
                  if (dni = aux^.dato.dni) then
                        contarB:= 1 + contarB;
                  aux:=aux^.sig;
            end;
      end;
      
      function  incisoB  (a:arbol; dni:integer): integer;
      begin
            if (a = nil) then incisoB:= 0
            else      incisoB:= contarB(a^.dato.list,dni) + incisoB (a^.HI,dni) + incisoB (a^.HD,dni) 
      end;
      
      function  contarC (l:lista; anio:integer): integer;
      var  aux:lista;
      begin
            aux:=l; contarC:=0;
            while  (aux <> nil) do
            begin
                  if (anio = aux^.dato.anio) then
                       contarC := 1 + contarC;       
                  aux:=aux^.sig;
            end;
      end;
      
         function  incisoC  (a:arbol; patente1,patente2:integer; anio:integer): integer;
      begin
            if (a = nil) then incisoC:= 0
            else  if  (patente1 <= a^.dato.patente) and  (patente2 >= a^.dato.patente)  then 
                   incisoC := contarC (a^.dato.list,anio) + incisoC (a^.HI,patente1,patente2,anio) +   incisoC (a^.HD,patente1,patente2,anio)
            else if  (patente1 > a^.dato.patente) then       incisoC := incisoC (a^.HD,patente1,patente2,anio)
            else  incisoC := incisoC (a^.HI,patente1,patente2,anio);
      end;
     
     procedure  imprimirL (l:lista);
     var  aux:lista;
     begin
          aux:=l;
          while (aux <> nil) do
          begin
                writeln ('|--------------------------------------------------|');
                writeln ('El DNI del alquiler es: ',aux^.dato.dni);
                writeln ('El mes del alquiler es: ',aux^.dato.mes);
                writeln ('El anio del alquiler es: ',aux^.dato.anio);
                writeln ('|--------------------------------------------------|');
                aux:=aux^.sig;
          end;
     end;
     
     procedure imprimirA (a:arbol);
     begin
           if (a<>nil) then
                 begin
                       imprimirA (a^.HD);
                       writeln ('|---------------------------------------------------------------|');
                       writeln ('La patente de los alquileres es: ', a^.dato.patente);
                       writeln ('|---------------------------------------------------------------|');
                       imprimirL (a^.dato.list);
                       imprimirA (a^.HI); 
                 end;
     end;
     
             
     var a:arbol;   dni, cantAlquileres: integer;   patente1,patente2,anio,cantAlquileresEntre:integer;
     begin
           a:=nil;
           randomize;
           cargarEstructura (a);
           imprimirA(a);
           readln (dni);
           cantAlquileres :=  incisoB (a,dni);
           writeln (cantAlquileres); 
           readln(patente1);
           readln(patente2);
           readln(anio);
           cantAlquileresEntre := incisoC (a,patente1,patente2,anio);
           writeln (cantAlquileresEntre);
      end.
           
               
             
             
             
             
             
             
             
             
             
             
             
       
   

       
       
       
       
              
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
        
        
