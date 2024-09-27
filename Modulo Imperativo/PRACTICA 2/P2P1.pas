{1.- Implementar un programa que invoque a los siguientes m dulos.

a. Un m dulo recursivo que retorne un vector de a lo sumo 15 n meros enteros  random  mayores a 10 y menores a 155 (incluidos ambos). La carga finaliza con 
el valor 20.


b. Un m dulo no recursivo que reciba el vector generado en a) e imprima el contenido del vector.


c. Un m dulo recursivo que reciba el vector generado en a) e imprima el contenido del vector.

d. Un m dulo recursivo que reciba el vector generado en a) y devuelva la suma de los valores pares contenidos en el vector.


e. Un m dulo recursivo que reciba el vector generado en a) y devuelva el m ximo valor del vector.


f. Un m dulo recursivo que reciba el vector generado en a) y un valor y devuelva verdadero si dicho valor se encuentra en el vector o falso en caso contrario.

g. Un m dulo que reciba el vector generado en a) e imprima, para cada n mero contenido en el vector, sus d gitos en el orden en que aparecen en el n mero. 
Debe implementarse un m dulo recursivo que reciba el n mero e imprima lo pedido. Ejemplo si se lee el valor 142, se debe imprimir 1  4  2
}

Program Clase2MI;
const dimF = 15;
      min = 10;
      max = 155;
type vector = array [1..dimF] of integer;
     

procedure CargarVector (var v: vector; var dimL: integer);

  procedure CargarVectorRecursivo (var v: vector; var dimL: integer);
  var valor: integer;
  begin
    valor:= min + random (max - min + 1);            //A ------------------------------------
    if ((valor <> 20 ) and (dimL < dimF)) 
    then begin
          dimL:= dimL + 1;
          v[dimL]:= valor;
          CargarVectorRecursivo (v, dimL);
         end;
  end;
  
begin
  dimL:= 0;
  CargarVectorRecursivo (v, dimL);
end;
 
procedure ImprimirVector (v: vector; dimL: integer);
var
   i: integer;
begin
     for i:= 1 to dimL do
         write ('----');
     writeln;
     write (' ');                            //B---------------------------------------------
     for i:= 1 to dimL do begin
        write(v[i], ' | ');
     end;
     writeln;
     for i:= 1 to dimL do
         write ('----');
     writeln;
     writeln;
End;     

procedure ImprimirVectorRecursivo (v: vector; dimL, pos: integer);
begin    
     if (pos<= diml) then
       begin
         writeln ('el numero de la posicion', pos , ' es: ', v[pos]);   //C---------------------------
         ImprimirVectorRecursivo(v,diml,pos+1);
       end;
end; 
    
function Sumar (v: vector; dimL: integer): integer; 

  function SumarRecursivo (v: vector; pos, dimL: integer): integer;

  Begin
    if (pos <= dimL) then 
       if (v[pos] mod 2 = 0) then
         SumarRecursivo:= SumarRecursivo (v, pos + 1, dimL) + v[pos]   //D--------------------------------
    else  SumarRecursivo:= SumarRecursivo (v, pos + 1, dimL) 
  End;
 
var pos: integer; 
begin
 pos:= 1;
 Sumar:= SumarRecursivo (v, pos, dimL);
end;

function  ObtenerMaximo (v: vector; dimL,pos,Max: integer): integer;
begin
    if (pos<=diml) then begin
       if (v[pos] > max) then                                        //E---------------------------------------
          max:= v[pos];
       ObtenerMaximo:= ObtenerMaximo(v,dimL,pos+1,Max);
    end
    else  
       max:= ObtenerMaximo;
end;     
     
function  BuscarValor (v: vector; dimL,valor,pos: integer): boolean;
begin
    if (pos<= dimL) and (v[pos] <> valor) then
        BuscarValor:=BuscarValor(v,dimL,valor,pos+1)
    else if (v[pos]=valor) then                                        //F-----------------------------------------
        BuscarValor:= true
    else 
        BuscarValor:= false;
end; 
 
procedure descomponer (num:integer; var reverso:integer);
       var  digito:integer;
       begin
          if (num > 0) then
           begin
                digito:= num mod 10;
                reverso:= reverso * 10 + digito;
                num:= num div 10;
                descomponer(num,reverso);
              end;
           end;  
procedure  imprimirNumOrden (v:vector; reverso, dimL, pos:integer);     
var 
   digito:integer; 
   begin 
      if (pos<= dimL) then
      begin
          descomponer(v[pos], reverso);
          writeln (' se ingresa el numero: ', v[pos]);              // G-------------------------------------------------
          while (reverso > 0) do
          begin
             digito:= reverso mod 10;
             writeln(digito);
             reverso:= reverso div 10;
          end;
          imprimirNumOrden(v,reverso,dimL,pos +1 );    
     end;
end;   
var dimL, suma, maximo, valor: integer; 
    v: vector; Maxi:integer; revers:integer;
    encontre: boolean; pos:integer;
Begin 
  revers:=0;
  pos:=1;  Maxi:= -1;
  CargarVector (v, dimL);
  writeln;
  if (dimL = 0) then writeln ('--- Vector sin elementos ---')
                else begin
                       ImprimirVector (v, dimL);
                  ImprimirVectorRecursivo (v, dimL,pos);
                     end;
  writeln;
  writeln;                   
  suma:= Sumar(v, dimL);
  writeln;
  writeln;
  writeln('La suma de los valores del vector es ', suma); 
  writeln;
  writeln;
  maximo:= ObtenerMaximo(v, dimL,pos,Maxi);
  writeln;
  writeln;
  writeln('El maximo del vector es ', maximo); 
  writeln;
  writeln;
  write ('Ingrese un valor a buscar: ');
  read (valor);
  encontre:= BuscarValor(v, dimL, valor,pos);
  writeln;
  writeln;
  if (encontre) then writeln('El ', valor, ' esta en el vector')
                else writeln('El ', valor, ' no esta en el vector');
  imprimirNumOrden (v,revers,dimL,pos);           
  writeln;
  writeln;
end.
