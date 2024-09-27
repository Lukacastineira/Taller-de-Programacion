{


4.- Realizar un programa que lea números y que utilice un módulo recursivo que escriba el
equivalente en binario de un número decimal. El programa termina cuando el usuario ingresa
el número 0 (cero).



Ayuda: Analizando las posibilidades encontramos que: Binario (N) es N si el valor es menor a 2.
¿Cómo obtenemos los dígitos que componen al número? ¿Cómo achicamos el número para la
próxima llamada recursiva? Ejemplo: si se ingresa 23, el programa debe mostrar: 10111.

}


procedure leerInt (var num:integer);
begin
   writeln('.');
   writeln(' ingrese numero que quiere convertir a binario: ');
    readln (num);
end;
procedure converB ( num:integer);
var      digito:integer;
begin
    digito:= 0;
    if ( num <> 0) then
    begin
      digito := num mod 2;
      num:= num div 2;
      converB (num); 
      write(digito);
    end;
end;
procedure leector (num:integer);
begin
    leerInt(num);
    if (num <> 0) then
    begin
       writeln (' El numero: ', num , ' en binario es: ');
       converB (num);
       leector(num);
    end;
end;  

var num:integer; 

begin 
   leector(num);
end.
