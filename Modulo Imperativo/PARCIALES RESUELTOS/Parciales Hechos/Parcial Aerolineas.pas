{


}

program  Castineira;


type 
     
      pasaje = record
           vuelo:integer;
           cliente:integer;
           destino:integer;
           monto:real;
      end;
      
      
      pasajeL= record
           vuelo:integer;
           cliente:integer;
           monto:real;
      end;
      
      lista = ^nodo;
      nodo= record
         dato:pasajeL;
         sig:lista;
      end;
       
      arbol = ^nodo1;
      nodo1= record
           destino:integer;
           list:lista;
           HI:arbol;
           HD:arbol;
      end;
      
      procedure  leerPasaje   (var p:pasaje);
      begin
          readln(p.monto);
           if (p.monto <> 0) then
           begin
               p.vuelo:= Random (7000);
               p.cliente:= Random (100) + 1;
               p.destino:= Random (10) + 1;
            end;
      end;
       
       procedure   agregarAdelante  (var l:lista; p:pasajeL);
       var nue:lista;
       begin
           new(nue);  nue^.dato:= p;  nue^.sig:= l; l:= nue;
       end;
      
       procedure   pasarP  ( var pL:pasajeL; vuelo,cliente:integer; monto:real);
       begin
              pL.vuelo:= vuelo;
              pL.cliente:= cliente;
              pL.monto:=monto;
        end;
      
      procedure  insertarArbol (var a:arbol;  destino:integer;  p:pasajeL);
      begin
          if (a = nil) then
          begin
               new (a); a^.destino:= destino; a^.list:=nil;
               agregarAdelante (a^.list, p);
               a^.HI:=nil; a^.HD:= nil;          
          end
          else if ( destino = a^.destino) then  agregarAdelante (a^.list,p)
          else if (destino < a^.destino) then insertarArbol(a^.HI,destino,p)
          else   insertarArbol(a^.HD,destino,p);
       end;
      
      
      procedure  cargarArbol  (var a:arbol);
      var    p:pasaje; pL: pasajeL;
      begin
           leerPasaje(p); 
           while  (p.monto <> 0) do
           begin
                  pasarP(pL,p.vuelo,p.cliente,p.monto);
                  insertarArbol (a,p.destino,pL);
                  leerPasaje(p);
            end;
      end;
      

       procedure  incisoB  (a:arbol;  var lB:lista; destinoB:integer);
       begin
               if (a=nil) then lB:= nil
              else if   ( destinoB = a^.destino) then  lB:=a^.list      
              else if ( destinoB > a^.destino ) then incisoB(a^.HD, lB, destinoB)
              else  incisoB(a^.HI, lB, destinoB);
       end;
       
       function   contarP (l:lista): integer;
       var aux:lista;  contar:integer;
       begin
             aux:=l; contar:=0;
             if (aux = nil) then contarP := 0
             else 
             begin
                while  (aux <> nil) do
                begin 
                        contar:= 1 + contar;
                        aux:=aux^.sig;
                end;
             end;
             contarP := contar;
       end;    
       
       procedure  incisoC  ( a:arbol;  var max:integer; var destinoC:integer);
       var  aux:integer; 
       begin
         if ( a<>nil) then
              begin
                     aux:= contarP (a^.list);
                   if ( max < aux) then
                   begin
                           max:= aux;
                          destinoC:= a^.destino;
                   end;
                     incisoC (a^.HI,max,destinoC);
                     incisoC (a^.HD,max,destinoC);            
                  end;
        end;
        
        procedure imprimirL (l:lista);
        var  aux:lista;
        begin
              aux:= l;
              while  (aux<>nil) do
              begin
                    writeln ('El monto del pasaje es: ',aux^.dato.monto:0:2);
                    writeln  ('El Numero de vuelo del pasaje es: ',aux^.dato.vuelo);
                    writeln  ('El Numero de cliente del pasaje es: ',aux^.dato.cliente);
                    aux:=aux^.sig;
               end;
          end; 
            
         procedure  imprimirA (a:arbol) ; 
         begin
               if (a<>nil) then
               begin
                          imprimirA (a^.HI);
                          writeln ('|------------------------------------------------------------|');
                          writeln ('El codigo de ciudad de destino es: ', a^.destino);
                          imprimirL (a^.list);
                          writeln ('|____________________________________|');
                          imprimirA(a^.HD);
               end;
         end;
                       
        
        var  a:arbol;  lB:lista; destinoB,max,destinoC:integer;
        begin
              a:=nil;  max:= -1; 
              randomize;
              cargarArbol (a);
              imprimirA(a);
              writeln ('ingrese ciudad de destino para guardar sus pasajes: ');
              readln (destinoB);
              incisoB(a,lB,destinoB);   
              if (lB = nil) then writeln ('hola');
              imprimirL (lB); 
              incisoC (a,max,destinoC);
              writeln (' La ciudad de destino con mayor cantidad de pasajes vendidos es: ', destinoC);
         end.
                    
              
       
       
      
      
    
