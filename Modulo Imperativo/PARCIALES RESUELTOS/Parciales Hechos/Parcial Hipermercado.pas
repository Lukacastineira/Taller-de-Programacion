program  castineira;

type

       compra = record
          codigo:integer;    // fin codigo 0
          factura:integer;
          cant:integer;
          monto:real;
       end;

       compraL = record
            factura:integer;
            cant:integer;
            monto:real;
        end;
        
        lista =^nodo;
        nodo = record 
            dato:compraL;
            sig:lista;
         end;
         
         arbol = ^nodo1;
         nodo1 = record
             codigo:integer;
             list:lista;
             HI:arbol;
             HD:arbol;
         end;
         
         
         procedure   leerCompra  ( var c:compra);
         begin  
                c.codigo:= Random (700);
                if (c.codigo <> 0) then
                  begin
                      c.factura:= Random(9998)+1;
                      c.cant:=Random (20)+1;
                      c.monto:= Random(2000) / (Random(10)+1);
                   end;
          end;
          
          procedure   agregarAdelante ( var l:lista;  c:compraL);
          var nue:lista;
          begin
                new(nue); nue^.dato:= c; nue^.sig:=l; l:=nue;
          end;
          
          procedure insertarArbol  (var a:arbol; codigo:integer; c:compraL);
          begin
              if(a=nil) then
              begin
                    new(a); a^.codigo:=codigo; a^.list:=nil;
                    agregarAdelante(a^.list,c);
                    a^.HI:=nil; a^.HD:=nil;
                end
                else  if  ( codigo = a^.codigo) then  agregarAdelante(a^.list, c)
                else if  (codigo < a^.codigo) then insertarArbol(a^.HI,codigo,c)
                else  insertarArbol(a^.HD,codigo,c);
           end;
           
           procedure pasarP (var  c:compraL; factura,cant:integer; monto:real);
           begin
                    c.factura := factura;
                    c.cant:=cant;
                    c.monto:=monto;
            end;
            
            procedure cargarArbol   (var a:arbol);
            var   c:compra;  cL:compraL;
            begin
                    leerCompra (c);
                    while  (c.codigo  <> 0 ) do
                    begin 
                          pasarP (cL, c.factura,c.cant,c.monto);
                          insertarArbol (a,c.codigo,cL);
                          leerCompra(c);
                     end;
            end;
           
          procedure   contarC  (l:lista; var montoT:real; var cant:integer );
           var  aux:lista;
           begin
                  aux:= l;  
                  begin
                       while  (aux <> nil) do
                       begin
                             montoT:= montoT + aux^.dato.monto;
                             cant:= cant + 1;
                             aux:=aux ^.sig;
                        end;     
                 end;
           end;
           
           procedure   incisoB  (a:arbol;  var montoT:real; var cant:integer; codigo:integer);
           begin
                  if (a = nil) then 
                  begin
                       montoT:=0; cant:= 0;
                  end
                  else if (codigo = a^.codigo) then   contarC(a^.list, montoT,cant) 
                  else  if (codigo > a^.codigo) then incisoB (a^.HD,montoT,cant,codigo)      
                  else  incisoB (a^.HI,montoT,cant,codigo);
            end;
            
            procedure  recorrerL (l:lista; var  listaC:lista; factura1,factura2:integer);
            var   aux:lista;
            begin
                  aux:=l;
                  while (aux<>nil) do 
                      begin
                              if (factura1 <= aux^.dato.factura) and  (factura2 >= aux^.dato.factura) then
                                          agregarAdelante (listaC, aux^.dato);
                              aux:=aux^.sig;
                       end;
            end;
            
            
            procedure  incisoC  (a:arbol;  var listaC:lista;  factura1, factura2:integer);
            begin               
                 if (a<>nil) then
                      begin
                            recorrerL(a^.list, listaC,factura1,factura2);
                             incisoC (a^.HI, listaC,factura1,factura2);
                             incisoC (a^.HD, listaC,factura1,factura2);
                      end;
             end;
             
             procedure imprimirL (l:lista);
             var aux:lista;
             begin
                   aux:=l;
                   while (aux<>nil) do
                   begin
                          writeln(' La factura de compra es: ', aux^.dato.factura);
                          writeln(' La cantidad de productos es: ', aux^.dato.cant);
                          writeln(' El monto de la compra es: ', aux^.dato.monto:0:2);
                          aux:=aux^.sig;
                   end;
             end;    
             
             procedure imprimirA   (a:arbol);
             begin
                 if (a<>nil) then
                 begin
                     imprimirA(a^.HI);
                         writeln ('|---------------------------------|');
                         writeln ('El codigo de cliente es: ', a^.codigo);
                         imprimirL(a^.list);
                         writeln ('|---------------------------------|');
                     imprimirA(a^.HD);
                   end;
             end;
             
             var   a:arbol;    codigo,cant:integer;  montoT:real;     factura1,factura2:integer;  listaC:lista;  
             begin  
                    a:=nil; listaC:=nil;
                    montoT:=0;  cant:=0;
                    cargarArbol(a);
                    imprimirA(a);
                    writeln('Ingrese codigo de cliente: ');
                    readln(codigo);
                    incisoB(a,montoT,cant,codigo);
                    writeln ('La cantidad de compras del cliente de codigo: ', codigo, ' es: ', cant);
                    writeln ('El monto total de las compras del cliente de codigo: ', codigo, ' es: ', montoT:0:2);
                    writeln('Ingrese Factura (1) : ');
                    readln(factura1);
                     writeln('Ingrese Factura (2 (mayor a la 1) : ');
                    readln(factura2);
                    incisoC (a,listaC,factura1,factura2);
                    imprimirL(listaC);
             end.
           
           
           
           
           
           
           
           
           
           
           
           
           
          
          
          
          
          
          
