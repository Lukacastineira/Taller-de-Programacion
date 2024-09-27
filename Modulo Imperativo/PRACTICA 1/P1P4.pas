{
4.- Una librería requiere el procesamiento de la información de sus productos. De cada
producto se conoce el código del producto, código de rubro (del 1 al 8) y precio.
Implementar un programa que invoque a módulos para cada uno de los siguientes puntos:



a. Lea los datos de los productos y los almacene ordenados por código de producto y
agrupados por rubro, en una estructura de datos adecuada. El ingreso de los productos finaliza
cuando se lee el precio 0.


b. Una vez almacenados, muestre los códigos de los productos pertenecientes a cada rubro.



c. Genere un vector (de a lo sumo 30 elementos) con los productos del rubro 3. Considerar que
puede haber más o menos de 30 productos del rubro 3. Si la cantidad de productos del rubro 3
es mayor a 30, almacenar los primeros 30 que están en la lista e ignore el resto.



d. Ordene, por precio, los elementos del vector generado en c) utilizando alguno de los dos
métodos vistos en la teoría.


e. Muestre los precios del vector resultante del punto d).



f. Calcule el promedio de los precios del vector resultante del punto d).

   
}


program P1P4;


const 
    dimf=30;
    
    
TYPE
  rango=1..8;
  producto = record
      codigo:integer;
      rubro:rango;
      precio:real;
  end;
  
  
  lista = ^nodo;
  nodo=record
      dato:producto;
      sig:lista;
  end;
  
  
  vectorL = array [rango] of lista;
  
  
  vector = array [1..dimf] of producto;


procedure inicializarL (var l:lista);                          
begin                                                         
    l:=nil;
end;

procedure inicializarV (var v:vectorL);
var i:integer;
begin
   for i := 1 to 8 do 
   begin
     v[i] := nil;
   end;
end;



procedure leerProducto  (var p:producto);
begin
      writeln (' Ingrese precio del producto: ');
      readln(p.precio);
      if (p.precio > 0 ) then 
      begin
          writeln (' Ingrese codigo de producto: ');
          readln (p.codigo);
          writeln (' Ingrese el codigo de rubro (entre 1 y 8) : ');
          readln (p.rubro);
      end;
end;



procedure  ingresarOrdenado (var pri:lista; p:producto);
var     act,ant,nue:lista; 
begin
   new(nue);
   nue^.dato:=p;
   act:=pri;
   ant:=pri;
   while  (act <> nil) and (act^.dato.codigo < p.codigo) do
   begin
         ant := act;
         act := act^.sig;
    end;
    if (ant = act) then
        pri:=nue
    else
      ant^.sig:= nue;
    nue^.sig:= act;
end; 




procedure generarL (var l:lista; var v:vectorL);
var  p:producto;  
begin
    leerProducto (p);
    while (p.precio > 0 ) do
    begin
        ingresarOrdenado (v[p.rubro],p);
        leerProducto(p);
    end;
end;
 
 
 
     
procedure imprimirLV (v:vectorL);
var i: integer;
begin 
      for i:= 1 to 8 do
      begin
         while (v[i] <> nil) do 
               begin
                  writeln('el codigo de producto es: ', v[i]^.dato.codigo);
                  writeln('el codigo de rubro es: ' , v[i]^.dato.rubro);
                  writeln('el precio es: ' , v[i]^.dato.precio);                              
                 v[i]:=v[i]^.sig;                                                                  
               end;
             writeln (' el rubro cambio a', i+1);
     end; 
end;




procedure vector3 (var v:vector; l:lista; var diml:integer);  
                                                
begin                                         
    diml:=0;                                   
    while (l <> nil) and (diml <= dimf) do
    begin
       if (l<>nil) then
            diml:= diml + 1;
            v[diml] := l^.dato;
       l:=l^.sig;
    end;
end;   




procedure ordenarV (var v: vector; diml:integer);   
       var   i,j:integer;      actual:producto;
  begin
       for i:= 2 to diml do 
          begin
             actual :=  v[i];
             j:= i-1;
             while (j>0) and (v[j].precio > actual.precio) do
                 begin  
                     v[j+1]:= v[j];
                     j:= j-1;
                 end;
             v[j+1]:= actual;
          end;
  end;



function  promedio (v:vector; diml:integer): real;
    var       precios,prom:real;     i:integer;
  begin
      precios:= 0;  prom:=0;
      for i:= 1 to diml do
            precios := precios + v[i].precio;
      prom:= precios / diml;
      promedio:= prom;
  end;   



procedure imprimirVOrdenado (v:vector
    var     i:integer;
  begin 

     for i:= 1 to diml do 
       begin
           writeln('el codigo de producto es: ', v3[i].codigo);
           writeln('el codigo de rubro es: ' , v3[i].rubro);
           writeln('el precio es: ' , v3[i].precio);  
       end;  
  end;



 var promedios:real; l:lista; v3:vector; v:vectorL; i,diml:integer;
begin
     promedios:= 0;
     inicializarL (l);
     inicializarV (v);
     generarL (l,v);  //A)
     imprimirLV (v);  //B)
     vector3 (v3, v[3], diml); //C) 
     ordenarV (v3,diml);  //D)
     imprimirVOrdenado (v3); //E)        
     promedios:= promedio(v3,diml);  // F)
     writeln ('el promedio de los precios del rubro 3 es: ', promedios:7:3,'%');
end.
