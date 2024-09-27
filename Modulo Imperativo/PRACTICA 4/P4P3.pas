{

3. Implementar un programa modularizado para una librería. Implementar módulos para:


a. Almacenar los productos vendidos en una estructura eficiente para la búsqueda por
código de producto. De cada producto deben quedar almacenados su código, la
cantidad total de unidades vendidas y el monto total. De cada venta se lee código de
venta, código del producto vendido, cantidad de unidades vendidas y precio unitario. El
ingreso de las ventas finaliza cuando se lee el código de venta -1.


b. Imprimir el contenido del árbol ordenado por código de producto.


c. Retornar el código de producto con mayor cantidad de unidades vendidas.


d. Retornar la cantidad de códigos que existen en el árbol que son menores que un valor
que se recibe como parámetro.


e. Retornar el monto total entre todos los códigos de productos comprendidos entre dos
valores recibidos (sin incluir) como parámetros.
   
}

Program P4P3; 

Type 
 venta = record
   codigoV:integer;     // finaliza codigo -1
   codigoP:integer;
   unidadesV:integer;
   precio:real;
 end;
 
  producto = record
    codigo:integer;
    unidadesVT :integer;
    montoTotal:real;
  end;
  
  arbol = ^nodo;
  nodo=record
    dato:producto;
    HI:arbol;
    HD:arbol;
  end;
procedure      leerVenta (var v:venta);
begin
       writeln (' Ingrese codigo de Venta: ');
       readln (v.codigoV);
       if (v.codigoV <> -1) then
       begin
       writeln (' Ingrese codigo de Producto: ');
       readln (v.codigoP);
       writeln (' Ingrese unidades Vendidas: ');
       readln (v.unidadesV);
       writeln (' Ingrese Precio: ');
       readln (v.precio);
       end;
end;


Procedure   InsertarP ( var p:producto; v:venta);
begin
      p.codigo:= v.codigoV;
      p.unidadesVT:=  v.unidadesV ;
      p.montoTotal:= v.unidadesV * v.precio;
end;

procedure   InsertarA (var a:arbol ; v:venta);
var p:producto;
begin
    if (a = nil) then
    begin
      new ( a);  
      InsertarP (p,v);
       a^.dato:= p; 
       a^.HD:= nil;  
       a^.HI :=  nil;
    end
    else  if ( v.codigoP = a^.dato.codigo)then 
    begin
                a^.dato.unidadesVT:= a^.dato.unidadesVT + v.unidadesV;
                a^.dato.montoTotal:= a^.dato.montoTotal + (v.unidadesV  * v.precio);
   end
    else if (v.codigoP < a^.dato.codigo) then  InsertarA (a^.HI, v)
    else  InsertarA (a^.HD, v);
end;


procedure CargarA (var a:arbol);
var v:venta;
begin
    leerVenta (v);
    while (v.codigoV <> -1) do                                                                                        ////// A---------------------------------------------------
    begin
           InsertarA(a,v);
           leerVenta(v);
    end;
end;    

procedure imprimirA (a:arbol) ;
begin
   if (a <> nil) then
   begin
             imprimirA(a^.HI);
             Writeln ('El codigo de producto es: ', a^.dato.codigo);
             Writeln ('La cantidad unidades totales vendidas es: ',a^.dato.unidadesVT);    ///// B --------------------------------------------------------
             Writeln ('El monto total de ventas del producto es: ', a^.dato.montoTotal:0:2);
            imprimirA(a^.HD);
  end;
end;     

procedure maxVentas (a:arbol; var codMax:integer; var unidadesMax:integer);
begin
     if (a<>nil) then
     begin 
        maxVentas(a^.HI,codMax,unidadesMax);   
       if  (a<>nil) and ( unidadesMax < a^.dato.unidadesVT) then                                /////// C------------------------------------------------------------
       begin
             codMax:= a^.dato.codigo;
             unidadesMax:=a^.dato.unidadesVT;
             writeln (unidadesMax);
       end; 
       maxVentas(a^.HD,codMax,unidadesMax);
     end;
 end;      
 
 
 Function       MenoresQue (a:arbol; x:integer) : integer;
 
begin
    if ( a=nil) then MenoresQue:=  0 
    else if  (a<> nil) and (x > a^.dato.codigo) then  
     MenoresQue:= 1 + MenoresQue(a^.HI,x) + MenoresQue (a^.HD,x)                       //////// D------------------------------------------------------------
     else if (a<>nil) then
     MenoresQue:=  MenoresQue (a^.HD,x) + MenoresQue(a^.HI,x) ;
end;
 
Function   ValoresTentre  (a:arbol;  num1,num2:integer) : real;
begin
    if (a=nil) then  ValoresTentre := 0
    else if  ( num1 < a^.dato.codigo) and (num2 > a^.dato.codigo) then   ValoresTentre := a^.dato.montoTotal + ValoresTentre(a^.HI,num1,num2) + ValoresTentre(a^.HD,num1,num2)   
    else if ( num1 >= a^.dato.codigo) then  ValoresTentre := ValoresTentre(a^.HD,num1,num2) 
    else   ValoresTentre :=  ValoresTentre(a^.HI,num1,num2) 
 end;
 
 var     a:arbol;  codMax:integer;   unidadesMax: integer;  menores:integer; x:integer;  montoE : real; num1,num2:integer;
 begin
     montoE:= 0;
     menores:= 0;
     unidadesMax:= -9999;
     a:=nil;
     CargarA(a);
     imprimirA(a);
     maxVentas(a,codMax,unidadesMax);
     if (codMax = 0) then writeln ('El arbol esta vacio.')
     else  writeln('El codigo de producto con mayor cantidad de ventas es: ', codMax) ;
     writeln ('Ingrese un numero, para buscar los codigos menores a ese numero: ');
     readln (x);
     menores:= MenoresQue(a,x);
     if (menores = 0) then writeln ('El arbol esta vacio.')
     else
     writeln ('Los codigos menores a ', x, ' son: ', menores);
     writeln ('Ingrese un numero: ');
     readln (num1);
     writeln ('Ingrese un numero (mayor al anterior):  ');
     readln (num2);
     montoE := ValoresTentre(a,num1,num2);
      writeln ('El monto total de los producto entre  ', num1, ' y ', num2, ' es: ', montoE:0:2);
end.
       
       
       
       
