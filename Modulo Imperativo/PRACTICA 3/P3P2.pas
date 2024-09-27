{
2. Escribir un programa que:

a. Implemente un módulo que genere aleatoriamente información de ventas de un comercio.
Para cada venta generar código de producto, fecha y cantidad de unidades vendidas. Finalizar
con el código de producto 0. Un producto puede estar en más de una venta. Se pide:


i. Generar y retornar un árbol binario de búsqueda de ventas ordenado por código de
producto. Los códigos repetidos van a la derecha.


ii. Generar y retornar otro árbol binario de búsqueda de productos vendidos ordenado por
código de producto. Cada nodo del árbol debe contener el código de producto y la
cantidad total de unidades vendidas.


iii. Generar y retornar otro árbol binario de búsqueda de productos vendidos ordenado por
código de producto. Cada nodo del árbol debe contener el código de producto y la lista de
las ventas realizadas del producto.


Nota: El módulo debe retornar TRES árboles.


b. Implemente un módulo que reciba el árbol generado en i. y una fecha y retorne la cantidad
total de productos vendidos en la fecha recibida.

c. Implemente un módulo que reciba el árbol generado en ii. y retorne el código de producto
con mayor cantidad total de unidades vendidas.


c. Implemente un módulo que reciba el árbol generado en iii. y retorne el código de producto
con mayor cantidad de ventas.

}


program P3P2;

TYPE
   venta = record
      codigo: integer;
      fecha: integer;
      unidades: integer;
   end;
   
   arbol = ^nodo1;
   nodo1=record
      dato:venta;
      HD:arbol;
      HI:arbol;
   end;
   
   venta2 = record
      codigo: integer;
      unidades: integer;
   end;
   
   arbol2 = ^nodo2;
   nodo2=record
      dato:venta2;
      HD:arbol2;
      HI:arbol2;
   end;
   regventa = record
      fecha:integer;
      unidades:integer;
   end;
    lista = ^nodo;
    nodo = record
       dato:regventa;
       sig:lista;
     end;
     
    
   arbol3 = ^nodo3;
     nodo3 = record
      dato:integer;
      list: lista;
      HD:arbol3;
      HI:arbol3;
  end;
   
     
      
procedure randomVenta (var v:venta);
begin
    readln(v.codigo);
    if (v.codigo <> 0) then
    begin
       v.fecha:= random (32-1)-1;
       v.unidades:= random (99-1)-1;
    end;
end;

procedure inicializarA (var a:arbol);
begin
    a:= nil;
end;


procedure InsertarA (var a:arbol; v:venta);
begin
     if (a = nil) then
     begin
     new(a); a^.dato:=v; a^.HI:=nil; a^.HD:=nil;
     end                                                         // i---------------------------------
      else   if (a^.dato.codigo > v.codigo) then
                InsertarA (a^.HI,v)
       else  InsertarA (a^.HD,v);
end;
 
                                                                   

procedure InsertarA2 (var a:arbol2; v:venta2);
begin
     if (a = nil) then
     begin
     new(a); a^.dato:=v; a^.HI:=nil; a^.HD:=nil;
     end                                                                                                                                             // i---------------------------------
     else if (a^.dato.codigo = v.codigo) then  a^.dato.unidades:= a^.dato.unidades + v.unidades
     else  if (a^.dato.codigo < v. codigo) then  InsertarA2 (a^.HD,v)
     else  InsertarA2 (a^.HI,v);
end;


procedure agregarA (var l:lista; v:regventa);
    var nue:lista;
    begin
      new(nue); nue^.dato:=v; nue^.sig:= l; l:= nue;
    end;


procedure InsertarA3 (var a:arbol3; c:integer; v:regventa);
  begin  
      if (a=nil) then 
      begin                             
         new (a); a^.dato:=c;  
          a^.list:=nil;
          agregarA(a^.list,v);
          a^.HD:= nil; a^.HI:= nil;
      end     
      else if (a^.dato = c ) then   agregarA(a^.list,v)    
      else if (a^.dato < c) then
       begin
       InsertarA3 (a^.HD,c,v)
       end
      else if (a^.dato > c) then   
      begin
      InsertarA3 (a^.HI,c,v);
      end;
 end;


procedure CargarA (var a:arbol; var a2:arbol2; var a3:arbol3);
var v:venta; v2:venta2; v3:regventa;
begin
    randomVenta (v);
    while ( v.codigo <> 0 ) do                                        //ii. Generar y retornar otro árbol binario de búsqueda de productos vendidos ordenado por código de producto. 
   begin                                                             //Cada nodo del árbol debe contener el código de producto y la cantidad total de unidades vendidas
        InsertarA (a,v);
        v2.codigo:= v.codigo;
        v2.unidades:= v.unidades; 
        InsertarA2(a2,v2);
        v3.fecha:= v.fecha;
        v3.unidades:= v.unidades;
        InsertarA3 (a3,v.codigo,v3);
        randomVenta(v);
    end;
end;


procedure  incisoI  (a:arbol; fecha:integer; var cant: integer);
begin
    if (a<> nil)  then
      begin 
          if  (a^.dato.fecha = fecha)  then 
             cant:=  cant + a^.dato.unidades;             
          incisoI (a^.HD,fecha,cant);
          incisoI (a^.HI,fecha,cant);     
        end;    
end;

procedure incisoII (a:arbol2; var max:integer; var codmax:integer);
begin
     if (a<>nil)  then
     begin
            if  (a^.dato.unidades >  max) then
            begin
                 max:= a^.dato.unidades;
                 codmax:=a^.dato.codigo; 
           end;
           incisoII (a^.HD,max,codmax);
           incisoII (a^.HI,max,codmax);
      end;
end;

procedure  incisoIII (a:arbol3; var codmaximo: integer;  var contmax:integer);
    var contador:integer;
    begin
           if (a <> nil ) then
               begin 
                        contador:= 0;
                         while    (   a^.list   <>   nil  )     do 
                         begin  
                                 contador:= contador + 1;
                                 a^.list:= a^.list^.sig;
                          end;
                         if (contador > contmax) then
                         begin   
                               contmax:= contador;
                               codmaximo:= a^.dato
                         end;
                         incisoIII(a^.HI,codmaximo,contmax); 
                         incisoIII(a^.HD,codmaximo,contmax); 
                 end;
     end;
procedure imprimirA (a:arbol);
begin
    if ( a <> nil ) then 
    begin
       imprimirA (a^.HD);     
       writeln ('El codigo de los hijos derechos es: ',a^.dato.codigo);
    end;
end;

procedure imprimirA2 (a:arbol2);
begin
    if ( a <> nil ) then 
    begin
       imprimirA2 (a^.HI);     
       imprimirA2 (a^.HD);   
       writeln ('|-------------------------------------------|');
       writeln ('|                    ARBOL 2                 |'); 
       writeln ('|-------------------------------------------|');
       writeln ('El codigo del producto es: ',a^.dato.codigo);
       writeln ('El total de unidades vendidas es: ',a^.dato.unidades);
       writeln ('|-------------------------------------------|');
    end;
end;

procedure imprimirL (l:lista);
begin
    while (l<>nil) do 
    begin 
             writeln ('|----------------------------------------|');
             writeln ('|                   LISTA                   |');
             writeln ('La fecha es: ',l^.dato.fecha);
            writeln ('El total de unidades vendidas es: ',l^.dato.unidades);
            writeln ('|----------------------------------------|');
          l:= l^.sig;
     end;
end;
procedure imprimirA3 (a:arbol3);
begin
    if ( a <> nil ) then 
    begin  
       imprimirA3 (a^.HI); 
       writeln ('El codigo del producto es: ',a^.dato);
       imprimirL(a^.list);    
       imprimirA3 (a^.HD);
    end;
end;

var a:arbol; a2:arbol2; a3:arbol3;  unidadesT, fechaB,  codmaxii, maxii,codmaximoiii,contmaxiii:integer;  
begin
     unidadesT:=0;
        codmaxii:= -1;
        maxii:= -1;
             codmaximoiii:=-1;
             contmaxiii:= 0;
    inicializarA(a);
    a2:=nil;
    a3:=nil;
   CargarA(a,a2,a3);
   imprimirA(a);
   imprimirA2(a2);
   imprimirA3(a3);
   writeln (' Ingrese fecha en la que quiere conocer total de unidades: ');
   readln (fechaB);
   incisoI (a,fechaB,unidadesT);
   writeln (' La cantidad de unidades vendidas de la fecha ', fechaB ,' es: ', unidadesT);
   incisoII(a2,maxii,codmaxii);
   writeln (' El producto con mayor cantidad de unidades totales vendidas es: ', codmaxii);
   incisoIII (a3,codmaximoiii,contmaxiii);
   writeln ('El producto con mayor cantidad de ventas es: ', codmaximoiii, ' con un total de: ',  contmaxiii , ' ventas. ');
end. 
