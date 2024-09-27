{
3.- Implementar un programa que invoque a los siguientes módulos.

a. Un módulo recursivo que retorne un vector de 20 números enteros “random” mayores a 300
y menores a 1550 (incluidos ambos).

b. Un módulo que reciba el vector generado en a) y lo retorne ordenado. (Utilizar lo realizado
en la práctica anterior)

c. Un módulo que realice una búsqueda dicotómica en el vector, utilizando el siguiente
encabezado:


Procedure busquedaDicotomica (v: vector; ini,fin: indice; dato:integer; var pos: indice);


Nota: El parámetro “pos” debe retornar la posición del dato o -1 si el dato no se encuentra
en el vector.
}


program P2P3;
const 
   min=299;
   max=1551;
type 
   vectorE = array [1..20] of integer; 
   
procedure randomN (var num:integer);
begin
   num:=random(max-min)+min;
end;

procedure cargarV (var v:vectorE; i:integer);
var num:integer;
begin
    if (i<=20) then
       begin                                                          // A---------------------------
          randomN(num);
          v[i]:= num;
          cargarV (v, i + 1);
       end;
end;


procedure ordenarV (var v:vectorE);
var   i,j,num:integer;
begin
    num:= 0;
    for i:= 2 to 20 do
    begin
       num:= v[i];
       j:= i-1;
          while (j>0) and (v[j] > num) do
          begin 
             v[j+1]:= v[j];
             j:=j-1;
          end;
          v[j+1] := num;
    end;
end;
procedure imprimirV (v:vectorE);
var i:integer;
begin
    for i:= 1 to 20 do
    begin
       writeln (v[i]);
    end;
end;


Procedure busquedaDicotomica (v: vectorE; ini,fin: integer; dato:integer; var pos: integer);
Var 
   medio: integer;
Begin
    medio := (ini + fin) div 2 ; 
    While (ini <= fin) and (dato <> v [medio]) do 
    begin
        If (dato < v[medio]) then 
           fin:= medio -1 
        else
            ini:= medio + 1 ;
        medio := (ini + fin) div 2 ;
    end;
    If (ini <= fin) then
        pos := medio
    else
        pos := -1;
End;  
var
 v:vectorE; i:integer; ini,f,dato,pos:integer;
BEGIN
    pos:= 0;
    f:= 20;
    ini:=1;
    i:= 1;
	cargarV (v,i);
    imprimirV (V);
    writeln ('--------');
    ordenarV (v);
    imprimirV (v);	
    writeln ('ingrese dato a encontrar: ');
    readln(dato);
    busquedaDicotomica(v,ini,f,dato,pos);
    if (pos<> -1) then
        writeln ('El dato que se buscaba esta en la posicion: ', pos)
    else
        writeln ('el dato no se encuentra en el vector ', pos);
END.

