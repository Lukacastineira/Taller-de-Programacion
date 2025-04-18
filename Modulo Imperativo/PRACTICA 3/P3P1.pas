{
1. Descargar el programa ImperativoEjercicioClase3.pas que contiene parte del código del
siguiente enunciado a resolver. Implementar lo indicado en el código.
Escribir un programa que:


a. Implemente un módulo que almacene información de socios de un club en un árbol binario
de búsqueda. De cada socio se debe almacenar número de socio, nombre y edad. La carga
finaliza con el número de socio 0 y el árbol debe quedar ordenado por número de socio. La
información de cada socio debe generarse aleatoriamente.


b. Una vez generado el árbol, realice módulos independientes que reciban el árbol como
parámetro y que :


i. Informar los datos de los socios en orden creciente.

ii. Informar los datos de los socios en orden decreciente.

iii. Informar el número de socio con mayor edad. Debe invocar a un módulo recursivo que
retorne dicho valor.


iv. Aumentar en 1 la edad de los socios con edad impar e informar la cantidad de socios
que se les aumentó la edad.


vi. Leer un nombre e informar si existe o no existe un socio con ese nombre. Debe invocar
a un módulo recursivo que reciba el nombre leído y retorne verdadero o falso.


vii. Informar la cantidad de socios. Debe invocar a un módulo recursivo que retorne dicha
cantidad.


viii. Informar el promedio de edad de los socios. Debe invocar a un módulo recursivo que
retorne el promedio de las edades de los socios.
}

Program ImperativoClase3;

type rangoEdad = 12..100;
     cadena15 = string [15];
     socio = record
               numero: integer;
               nombre: cadena15;
               edad: rangoEdad;
             end;
     arbol = ^nodoArbol;
     nodoArbol = record
                    dato: socio;
                    HI: arbol;
                    HD: arbol;
                 end;
     
procedure GenerarArbol (var a: arbol);
{ Implementar un modulo que almacene informacion de socios de un club en un arbol binario de busqueda. De cada socio se debe almacenar numero de socio, 
nombre y edad. La carga finaliza con el numero de socio 0 y el arbol debe quedar ordenado por numero de socio. La informacion de cada socio debe generarse
aleatoriamente. }

  Procedure CargarSocio (var s: socio);
  var vNombres:array [0..9] of string= ('Ana', 'Jose', 'Luis', 'Ema', 'Ariel', 'Pedro', 'Lena', 'Lisa', 'Martin', 'Lola'); 
  
  begin
    s.numero:= random (51) * 100;
    If (s.numero <> 0)
    then begin
           s.nombre:= vNombres[random(10)];
           s.edad:= 12 + random (79);
         end;
  end;  
  
  Procedure InsertarElemento (var a: arbol; elem: socio);
  Begin
    if (a = nil) 
    then begin
           new(a);
           a^.dato:= elem; 
           a^.HI:= nil; 
           a^.HD:= nil;
         end
    else if (elem.numero < a^.dato.numero) 
         then InsertarElemento(a^.HI, elem)
         else InsertarElemento(a^.HD, elem); 
  End;
           
var unSocio: socio;  
Begin
 writeln;
 writeln ('----- Ingreso de socios y armado del arbol ----->');
 writeln;
 a:= nil;
 CargarSocio (unSocio);
 while (unSocio.numero <> 0)do
  begin
   InsertarElemento (a, unSocio);
   CargarSocio (unSocio);
  end;
 writeln;
 writeln ('//////////////////////////////////////////////////////////');
 writeln;
end;

procedure InformarSociosOrdenCreciente (a: arbol);
{ Informar los datos de los socios en orden creciente. }
  
  procedure InformarDatosSociosOrdenCreciente (a: arbol);
  begin
    if ((a <> nil) and (a^.HI <> nil))
    then InformarDatosSociosOrdenCreciente (a^.HI);
    writeln ('Numero: ', a^.dato.numero, ' Nombre: ', a^.dato.nombre, ' Edad: ', a^.dato.edad);
    if ((a <> nil) and (a^.HD <> nil))
    then InformarDatosSociosOrdenCreciente (a^.HD);
  end;

Begin
 writeln;
 writeln ('----- Socios en orden creciente por numero de socio ----->');
 writeln;
 InformarDatosSociosOrdenCreciente (a);
 writeln;
 writeln ('//////////////////////////////////////////////////////////');
 writeln;
end;


procedure InformarNumeroSocioConMasEdad (a: arbol);
{ Informar el numero de socio con mayor edad. Debe invocar a un modulo recursivo que retorne dicho valor.  }

     procedure actualizarMaximo(var maxValor,maxElem : integer; nuevoValor, nuevoElem : integer);
	begin
	  if (nuevoValor >= maxValor) then
	  begin
		maxValor := nuevoValor;
		maxElem := nuevoElem;
	  end;
	end;
	procedure NumeroMasEdad (a: arbol; var maxEdad: integer; var maxNum: integer);
	begin
	   if (a <> nil) then
	   begin
		  actualizarMaximo(maxEdad,maxNum,a^.dato.edad,a^.dato.numero);
		  numeroMasEdad(a^.hi, maxEdad,maxNum);
		  numeroMasEdad(a^.hd, maxEdad,maxNum);
	   end; 
	end;

var maxEdad, maxNum: integer;
begin
  writeln;
  writeln ('----- Informar Numero Socio Con Mas Edad ----->');
  writeln;
  maxEdad := -1;
  NumeroMasEdad (a, maxEdad, maxNum);
  if (maxEdad = -1) 
  then writeln ('Arbol sin elementos')
  else begin
         writeln;
         writeln ('Numero de socio con mas edad: ', maxNum);
         writeln;
       end;
  writeln;
  writeln ('//////////////////////////////////////////////////////////');
  writeln;
end;

procedure AumentarEdadNumeroImpar (a: arbol);
{Aumentar en 1 la edad de los socios con edad impar e informar la cantidad de socios que se les aumento la edad.}
  
  function AumentarEdad (a: arbol): integer;
  var resto: integer;
  begin
     if (a = nil) 
     then AumentarEdad:= 0
     else begin
            resto:= a^.dato.edad mod 2;
            if (resto = 1) then a^.dato.edad:= a^.dato.edad + 1;
            AumentarEdad:= resto + AumentarEdad (a^.HI) + AumentarEdad (a^.HD);
          end;  
  end;

begin
  writeln;
  writeln ('----- Cantidad de socios con edad aumentada ----->');
  writeln;
  writeln ('Cantidad: ', AumentarEdad (a));
  writeln;
  writeln;
  writeln ('//////////////////////////////////////////////////////////');
  writeln;
end;

procedure   InformarSociosOrdenDecreciente ( a:arbol);
begin 
    if (a <> nil) then
    begin
    InformarSociosOrdenDecreciente(a^.HD);
    writeln ('Numero: ', a^.dato.numero, ' Nombre: ', a^.dato.nombre, ' Edad: ', a^.dato.edad);
    InformarSociosOrdenDecreciente(a^.HI);
    end;
end;

procedure InformarExistenciaNombreSocio (a:arbol; x:cadena15; var encontre:boolean);
begin  
   if ( a<>nil) then 
   begin       
       InformarExistenciaNombreSocio (a^.HI,x,encontre); 
       if (a^.dato.nombre = x) then encontre:= true;
       InformarExistenciaNombreSocio (a^.HD,x,encontre);
   end;
end;
procedure   InformarCantidadSocios (a:arbol; var cant:integer); 
begin
     if (a <> nil) then
     begin
     InformarCantidadSocios(a^.HI,cant);
     cant:= cant + 1;
     InformarCantidadSocios(a^.HD,cant);
     end;
end;    
procedure  InformarPromedioDeEdad (a:arbol; cant:integer; var promedio:integer);
begin
    if (a<> nil) then
    begin
      InformarPromedioDeEdad (a^.HI,cant,promedio);
      promedio:= promedio + a^.dato.edad;
      InformarPromedioDeEdad (a^.HD,cant,promedio);
    end;
end;

var a: arbol; x:cadena15 ; encont:boolean; cant:integer; promedio:integer;
Begin
  promedio:= 0;
  cant:= 0;
  encont:= false;
  randomize;
  GenerarArbol (a);
  InformarSociosOrdenCreciente (a);
  InformarSociosOrdenDecreciente (a);
  InformarNumeroSocioConMasEdad (a);
  AumentarEdadNumeroImpar (a);
  writeln ('Ingrese Nombre de socio a buscar en el arbol: ');
  readln(x);
  InformarExistenciaNombreSocio (a,x,encont); 
  if  (encont) then writeln (' El nombre ', x , ' esta en el arbol')
  else
     writeln (' El nombre ', x , ' no esta en el arbol');
  InformarCantidadSocios (a,cant); 
  writeln('La cantidad total de socios es ', cant);
  InformarPromedioDeEdad (a,cant,promedio);  
  promedio:= promedio div cant; 
  writeln ('La edad promedio de los socios es : ', promedio);
End.
