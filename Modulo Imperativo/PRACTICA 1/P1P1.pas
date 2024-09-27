{1.- Se desea procesar la información de las ventas de productos de un comercio (como máximo
50).

Implementar un programa que invoque los siguientes módulos:

a. Un módulo que retorne la información de las ventas en un vector. De cada venta se conoce el
día de la venta, código del producto (entre 1 y 15) y cantidad vendida (como máximo 99
unidades). El código debe generarse automáticamente (random) y la cantidad se debe leer. El
ingreso de las ventas finaliza con el día de venta 0 (no se procesa).

b. Un módulo que muestre el contenido del vector resultante del punto a).

c. Un módulo que ordene el vector de ventas por código.

d. Un módulo que muestre el contenido del vector resultante del punto c).

e. Un módulo que elimine, del vector ordenado, las ventas con código de producto entre dos
valores que se ingresan como parámetros.

f. Un módulo que muestre el contenido del vector resultante del punto e).

g. Un módulo que retorne la información (ordenada por código de producto de menor a
mayor) de cada código par de producto junto a la cantidad total de productos vendidos.

h. Un módulo que muestre la información obtenida en el punto g).}

                             
 PROGRAM P1P1;
 CONST
   Dimf=50;
TYPE  
    codigo=1..15; cantidad=1..99; dia=0..31;                
    venta = RECORD                                                       
     dia_venta:dia;                                                 
     product_code:codigo;                                              
     cant_vendida:cantidad;                                              
    END;
    ventas = ARRAY [1..50] OF venta;
    lista = ^nodo;
    nodo=record
      sig:lista;
      dato:venta;
    end;
PROCEDURE  Leer_Venta (VAR v:venta);
 BEGIN 
   RANDOMIZE;
   v.dia_venta := random(31);
   writeln ('dia de venta: ' , v.dia_venta);
   if (v.dia_venta <> 0) then 
     begin
        v.product_code := random(15);
        writeln ('codigo de producto: ' , v.product_code);
        Writeln ('ingrese la cantidad vendida (ENTRE 1 Y 99)');
        readln (v.cant_vendida);
     END;   
 END;


PROCEDURE  Cargar_Venta ( VAR vs:ventas; VAR Diml:INTEGER);
 VAR v:venta;
 begin
    Diml:=0;
    Leer_Venta (v);                                                        //a. Un módulo que retorne la información de las ventas en un vector. De cada venta se conoce el
    WHILE (v.dia_venta> 0) AND (Diml < 50) DO                                // día de la venta, código del producto (entre 1 y 15) y cantidad vendida (como máximo 99
      BEGIN                                                              // unidades). El código debe generarse automáticamente (random) y la cantidad se debe leer. El
        Diml:= Diml + 1;                                                // ingreso de las ventas finaliza con el día de venta 0 (no se procesa).
        vs[Diml] := v ;
        Leer_Venta(v)
      END;
  END;
 
PROCEDURE  Leo_venta (v:venta);
BEGIN
   writeln (' el dia de venta fue: ' , v.dia_venta);
   writeln (' el codigo de producto: ' , v.product_code);
   writeln ('la cantidad vendida fue: ' , v.cant_vendida);
END;
  
PROCEDURE  Recorrer_Ventas (vs:ventas; Diml:INTEGER);                   // b. Un módulo que muestre el contenido del vector resultante del punto a).
  VAR  i:integer;
  BEGIN 
     i := 1;
     FOR  i := 1 to Diml DO
       BEGIN
         Leo_venta(vs[i]);
       END;
  END;                         
                                                                                   //c. Un módulo que ordene el vector de ventas por código.
 procedure Ordenar (var vs: ventas; Diml: integer);

var i, j, pos: integer; v: venta;	
		
begin
 for i:= 1 to Diml - 1 do 
 begin {busca el mínimo y guarda en pos la posición}
   pos := i;
   for j := i+1 to Diml do 
        if (vs[j].product_code < vs[pos].product_code) then pos:=j;

   {intercambia v[i] y v[pos]}
   v := vs[pos];   
   vs[pos] := vs[i];   
   vs[i] := v;
 end;
end;
  
procedure Inicializar_Lista (var l:lista);
begin
  l:=nil;
end;

procedure  Agregar_Lista (var l:lista; v:venta);
var aux:lista;
begin
  new(aux);
   aux^.dato:= v; 
   aux^.sig:= l; 
   l:=aux;
END; 

procedure Cumplecondicion (c:codigo; var Cumple:boolean);
  begin
   if (c mod 2 = 0) then
     Cumple:= true;
 END;


PROCEDURE Generar_Lista (var l:lista; vs:ventas; Diml:integer; Cumple:boolean);
VAR  i:integer; 
BEGIN
  i:= 1;
  for i:= diml downto 1 do 
    begin
      Cumplecondicion(vs[i].product_code, Cumple);
      if (Cumple) then 
        Agregar_Lista(l,vs[i]);
    END;
end;                                                                           //g. Un módulo que retorne la información (ordenada por código de producto de menor a
                                                                              //mayor) de cada código par de producto junto a la cantidad total de productos vendidos.
PROCEDURE Imprimir_Lista (l:lista);
begin
  while (l<>nil) do 
  begin
     writeln (' el dia de venta fue: ' , l^.dato.dia_venta);
     writeln (' el codigo de producto: ' , l^.dato.product_code);                    //{h. Un módulo que muestre la información obtenida en el punto g).}
     writeln ('la cantidad vendida fue: ' , l^.dato.cant_vendida);
     l:=l^.sig;
  end;
END;
VAR
 vs1:ventas; l1:lista; Diml1:integer; Cumple:boolean;
BEGIN
  Cumple:= false;
  Inicializar_Lista(l1);
  Cargar_Venta (vs1,Diml1); //A
  Recorrer_Ventas (vs1,Diml1); //B
  Ordenar(vs1,Diml1); //C
  Recorrer_Ventas (vs1,Diml1); //D
  Generar_Lista(l1,vs1,Diml1,Cumple); //G
  Imprimir_Lista(l1);
end.
