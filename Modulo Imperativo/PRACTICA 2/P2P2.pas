{
2.- Escribir un programa que:


a. Implemente un módulo recursivo que genere y retorne una lista de números enteros
“random” en el rango 100-200. Finalizar con el número 100.


b. Un módulo recursivo que reciba la lista generada en a) e imprima los valores de la lista en el
mismo orden que están almacenados.


c. Implemente un módulo recursivo que reciba la lista generada en a) e imprima los valores de
la lista en orden inverso al que están almacenados.

d. Implemente un módulo recursivo que reciba la lista generada en a) y devuelva el mínimo
valor de la lista.

e. Implemente un módulo recursivo que reciba la lista generada en a) y un valor y devuelva
verdadero si dicho valor se encuentra en la lista o falso en caso contrario.

}
 
 
PROGRAM   P2P2;

const
   max=200;
   min=100;
type 
    lista = ^nodo;
      nodo= record
      dato:integer;
      sig:lista;
    end;


procedure crearL (var l:lista);
begin
   l:= nil;
end;  


procedure numRandom (var num:integer);
begin
   num:= random(max-min)+ min;
end;


procedure agregarAdelante (var l:lista; num:integer);
var aux:lista;
begin
  new(aux);
  aux^.dato:= num;
  aux^.sig:=l;
  l:= aux;
end;

procedure generarL (var l:lista);
   var num:integer; 
   begin   
        numRandom(num);
        if (num <> min) then                                          //A-------------------------
        begin
            agregarAdelante (l,num);
            generarL (l);
        end;
   end;
   
procedure imprimirL (l:lista);
begin
    if (l<>nil) then
    begin                                                             //B---------------------------
       writeln ('Lista como fue ingresada:', l^.dato); 
       imprimirL(l^.sig);
    end;
end;

procedure imprimirLalReves (l:lista);
begin   
     if (l <> nil) then
     begin                                                           //C------------------------------
         imprimirLalReves(l^.sig);
         writeln('lista al reves:', l^ .dato);
     end;   
End;

procedure minimoL (l:lista; var  min:integer);
begin
    if (l<> nil) then
       begin                                                        //D-----------------------------------
          if (min > l^.dato) then
              min:= l^.dato;
          minimoL(l^.sig,min);
       end;
end;   

function valorenL (l:lista; valor:integer):boolean;
begin
    if (l<> nil) and (valor <> l^.dato) then
        valorenL:=valorenL(l^.sig,valor)
    else if (l<>nil) and (valor = l^.dato) then                      //E-------------------------------------
         valorenL:= true
    else
         valorenL := false;
end;    
var l:lista; mini:integer; valori:integer; encontre:boolean;

begin
    encontre:= false;
    mini:=max;
    crearL (l);
    generarL(l);
    imprimirL(l);
    imprimirLalReves(l);
    minimoL(l,mini);
    writeln ('el minimo es: ', mini);
    writeln ('ingrese numero a buscar en lista: ');
    readln(valori);
    encontre:= valorenL(l,valori); 
    if (encontre) then
          writeln ('El valor ', valori, ' esta en la lista')
    else 
          writeln ('El valor ', valori, ' no esta en la lista');
end.
