{
4. Una biblioteca nos ha encargado procesar la información de los préstamos realizados
durante el año 2021. De cada préstamo se conoce el ISBN del libro, el número de socio, día
y mes del préstamo y cantidad de días prestados. Implementar un programa con:

a. Un módulo que lea préstamos y retorne 2 estructuras de datos con la información de
los préstamos. La lectura de los préstamos finaliza con ISBN 0. Las estructuras deben
ser eficientes para buscar por ISBN.


i. En una estructura cada préstamo debe estar en un nodo. Los ISBN repetidos
insertarlos a la derecha.


ii. En otra estructura, cada nodo debe contener todos los préstamos realizados al ISBN.
(prestar atención sobre los datos que se almacenan).


b. Un módulo recursivo que reciba la estructura generada en i. y retorne el ISBN más
grande.


c. Un módulo recursivo que reciba la estructura generada en ii. y retorne el ISBN más
pequeño.


d. Un módulo recursivo que reciba la estructura generada en i. y un número de socio. El
módulo debe retornar la cantidad de préstamos realizados a dicho socio.

e. Un módulo recursivo que reciba la estructura generada en ii. y un número de socio. El
módulo debe retornar la cantidad de préstamos realizados a dicho socio.


f. Un módulo que reciba la estructura generada en i. y retorne una nueva estructura
ordenada ISBN, donde cada ISBN aparezca una vez junto a la cantidad total de veces 
que se prestó.


g. Un módulo que reciba la estructura generada en ii. y retorne una nueva estructura
ordenada ISBN, donde cada ISBN aparezca una vez junto a la cantidad total de veces
que se prestó.


h. Un módulo recursivo que reciba la estructura generada en g. y muestre su contenido.


i. Un módulo recursivo que reciba la estructura generada en i. y dos valores de ISBN. El
módulo debe retornar la cantidad total de préstamos realizados a los ISBN
comprendidos entre los dos valores recibidos (incluidos).


j. Un módulo recursivo que reciba la estructura generada en ii. y dos valores de ISBN. El
módulo debe retornar la cantidad total de préstamos realizados a los ISBN
comprendidos entre los dos valores recibidos (incluidos).

   
}


program  P4P4;

CONST

     Dias=31;   Meses= 12;
     
     
TYPE

     RangoDias= 1..Dias;   RangoMes = 1..Meses;
     
     Prestamo = record
          ISBN: integer;
          numSocio:integer;
          dia:RangoDias;
          mes:RangoMes;
          cantDiasPrestado:integer;
     end;
     
     arbol = ^nodo1;
     nodo1 = record
       dato:Prestamo;
       HD:arbol;
       HI:arbol;    
     end;
     
     PrestamoL = record
        numSocio:integer;
        dia:RangoDias;
        mes:RangoMes;
        cantDiasPrestado:integer;
    end;
     
     lista = ^nodo;
     nodo = record
        dato:PrestamoL;
        sig:lista;
     end;
     
     arbol2 = ^nodo2;
     nodo2= record
          list:lista;
          ISBN:integer;
          HD:arbol2;
           HI:arbol2;
      end;
      
      arbolF = ^nodo3;
      nodo3 =record
           ISBN:integer;
           cantPrestado:integer;
           HI:arbolF;
           HD:arbolF;
       end;
       
       

  procedure   leerP   (var p:Prestamo);
  begin
       writeln (' Ingrese ISBN del libro: ' );
       readln (p.ISBN);
       if (p.ISBN <> 0) then 
       begin
           writeln (' Ingrese Numero de Socio: ' );
           readln (p.numSocio);
           writeln (' Ingrese Dia: ' );
           readln (p.dia);
           writeln (' Ingrese Mes: ' );
           readln (p.mes);
           writeln (' Ingrese la cantidad de dias prestado: ' );
           readln (p.cantDiasPrestado);
     end;
end;


procedure   InsertarArbol   (var a:arbol;   p:Prestamo);
begin
     if ( a = nil) then
         begin
             new(a);   a^.dato:=p;  a^.HI:=nil;  a^.HD:=nil;
          end
          else if (p.ISBN  < a^.dato.ISBN) then   InsertarArbol(a^.HI, P)
          else   InsertarArbol(a^.HD, p);
end;

 procedure  pasarP   (Var pL:PrestamoL;  numSocio:integer;   dia:RangoDias;  mes:RangoMes; cantDiasPrestado:integer);
 begin
       pL.numSocio :=numSocio;
       pL.dia:= dia;
       pL.mes:=mes;
       pL.cantDiasPrestado:= cantDiasPrestado;
end; 

procedure agregarAdelante  (var l:lista;  pL:PrestamoL);
Var   nue:lista;

begin
          new(nue); nue^.dato:=pL;   nue^.sig:=l;  l:=nue;
end;


procedure   InsertarArbol2  (var a2:arbol2; isbn:integer;  pL:PrestamoL);
Begin
       if (a2 = nil) then
       begin
           new(a2);   a2^.ISBN := isbn;  a2^.list:=nil;
           agregarAdelante (a2^.list, pL); 
           a2^.HI :=nil;
           a2^.HD:=nil;
      end
      else if (isbn = a2^.ISBN) then   agregarAdelante (a2^.list, pL)
      else if (isbn < a2^.ISBN) then   InsertarArbol2 (a2^.HI,isbn,pL)
      else   if (isbn > a2^.ISBN) then InsertarArbol2 (a2^.HD,isbn,pL)
 end;
 
 
 procedure   CargarArboles   (var a:arbol;  var a2:arbol2);
 var    p:prestamo;  pL:PrestamoL; 
Begin
     leerP (p);
     while  ( p.ISBN <> 0)  do
     begin
            pasarP(pL  ,   p.numSocio ,  p.dia   ,   p.mes   ,   p. cantDiasPrestado);
            InsertarArbol(a,p);                                                                                               ////// i--------------------------------------------------------
            InsertarArbol2(a2,p.ISBN,pL);                                                                            /////  ii--------------------------------------------------------
            leerP(p);
     end;
end;

function  Maxi   (a:arbol): integer;
begin
     if (a=nil) then Maxi:=0
     else if (a^.HD=nil) then  Maxi:= a^.dato.ISBN                                                        ///// B----------------------------------------------------------
     else  Maxi:= Maxi (a^.HD);
end;
     
           

function  Mini   (a2:arbol2): integer;
begin
     if (a2=nil) then Mini:=0
     else if (a2^.HI=nil) then  Mini:= a2^.ISBN                                                        ///// C----------------------------------------------------------
     else  Mini:= Mini (a2^.HI);
end;
     
function  cantPrestamosi   (a:arbol; numi:integer): integer;
begin
      if  (a= nil) then  cantPrestamosi:= 0
      else if (a^.dato.numSocio = numi) then  cantPrestamosi:= 1 + cantPrestamosi(a^.HI,numi) + cantPrestamosi(a^.HD,numi)                               ///// D------------------------------------------------------
       else    cantPrestamosi:=cantPrestamosi(a^.HI,numi) + cantPrestamosi(a^.HD,numi);     
end;


function cantPrestamosii  (a:arbol2;  numii:integer) :integer;
var  aux:lista;
begin
         if (a=nil) then cantPrestamosii:= 0
         else if (  a <>  nil ) then 
         begin  
              cantPrestamosii:=  cantPrestamosii (a^.HI,numii) ;
               cantPrestamosii:=  cantPrestamosii (a^.HD,numii) ;             
               aux:= a^.list;                                                                                                /////// E------------------------------------------------------
               while (aux<>nil) do
                    begin
                          if  ( aux^.dato.numSocio = numii) then
                                cantPrestamosii := cantPrestamosii + 1;
                          aux:= aux^.sig;
                   end;       
          end;
end;


procedure  insertarAF  (var aF:arbolF;  isbn:integer);
begin
          if (aF = nil) then
          begin
                 new(aF);  aF^.ISBN:=isbn; aF^.cantPrestado:= 1; aF^.HI:= nil;  aF^.HD:= nil;
          end
          else  if (aF^.ISBN = isbn) then  aF^.cantPrestado:= aF^.cantPrestado + 1
          else 
          if  (aF^.ISBN > isbn) then insertarAF(aF^.HI, isbn)
          else
                insertarAF(aF^.HD, isbn);                      
end;

function   contarP ( l:lista) : integer;
var   aux:lista;
begin 
        contarP:=  0;
        aux:=l;
         While (aux<>nil)  do
         begin
                  contarP:= 1 + contarP;
                  aux:=aux^.sig;
         end;
end;


procedure insertarAG  (var aG:arbolF; isbn:integer; cantP:integer);
begin
      if (aG = nil ) then
      begin  
            new(aG);  aG^.ISBN := isbn; aG^.cantPrestado:=cantP; aG^.HI:=nil; aG^.HD:=nil;
      end
      else if (isbn < aG^.ISBN) then  insertarAG (aG^.HI, isbn, cantP)
      else  insertarAG (aG^.HD, isbn, cantP)
end;     



procedure  cargarAF  (a:arbol;  var aF:arbolF);
begin 
      if (a<>nil) then
          begin
                cargarAF (a^.HI, aF);
                insertarAF (aF, a^.dato.ISBN);                                                                        //////    F--------------------------------------------------------
                cargarAF (a^.HD,aF);
          end;
end;




procedure cargarAG (a2:arbol2; var aG:arbolF) ;
begin 
      if (a2<>nil) then
             begin
                 cargarAG(a2^.HI,aG);    
                 insertarAG(aG,a2^.ISBN, contarP (a2^.list) );                                            ///////      G-------------------------------------------------------------
                 cargarAG(a2^.HD,aG);                                                                         
              end;
end;

                     

 procedure imprimir	( l:lista) ;
begin
      while (l<>nil) do
        begin
              writeln ('El numero de socio es: ', l^.dato.numSocio);
              writeln ('El dia es: ', l^.dato.dia);
              writeln ('El mes es: ', l^.dato.mes);
              writeln ('La cantidad de dias prestado es: ', l^.dato.cantDiasPrestado);
              l:=l^.sig;
        end;
end;       
 
procedure  imprimirA2   (a:arbol2);
begin
        if (a<>nil) then
        begin
                imprimirA2 (a^.HI);
                writeln  ('El ISBN del libro es: ', a^.ISBN) ;
                imprimir (a^.list);
               imprimirA2(a^.HD);
        end;
end;


procedure  imprimirAF  (a:arbolF);
begin
      if (a<> nil) then 
         begin
                imprimirAF(a^.HI);
                writeln (' El libro con ISBN: ', a^.ISBN);
                writeln (' Fue prestado: ', a^.cantPrestado, ' veces. ');
                imprimirAF(a^.HD);
         end;
end;

procedure  imprimirAG  (aG:arbolF);
begin
      if (aG<> nil) then 
         begin
                imprimirAF(aG^.HI);
                writeln (' El libro con ISBN: ', aG^.ISBN);                                                         /////// H---------------------------------------------------
                writeln (' Fue prestado: ', aG^.cantPrestado, ' veces. ');
                imprimirAF(aG^.HD);
         end;
end;


function  Incisoi  (a:arbol; num1,num2:integer):integer;
begin               
         if(a=nil) then Incisoi:=0
         else                                                                                                                  
         if(a<>nil) and ( num1 <= a^.dato .ISBN)  and (num2 >= a^.dato.ISBN)  then      //////// i -----------------------------------------------------                                                                                                
                  Incisoi:= 1 + Incisoi (a^.HI,num1,num2) + Incisoi (a^.HD,num1,num2) 
         else   if (num1  > a^.dato.ISBN) then   Incisoi:= incisoi (a^.HD,num1,num2)
         else Incisoi:=Incisoi(a^.HI,num1,num2);      
end;                                                                  


function   IncisoJ ( a2:arbol2; num1,num2:integer):integer;     
begin                                                                                                                                /////   J------------------------------------------------------
       if (a2=nil) then   IncisoJ:= 0
       else if (a2<>nil) and ( num1 <= a2^.ISBN) and  (num2>= a2^.ISBN) then  IncisoJ:= contarP(a2^.list) + IncisoJ(a2^.HI,num1,num2) + IncisoJ(a2^.HD,num1,num2)
       else  if (num1 > a2^.ISBN) then IncisoJ(a2^.HD,num1,num2)
       else  IncisoJ(a2^.HI,num1,num2)
end;



var              a:arbol; a2:arbol2;   max:integer;  min:integer;  numi,numii:integer; cantidadPi :integer;   cant :integer;  aF:arbolF; aG:arbolF;   isbn1,isbn2,isbn3,isbn4:integer;  cantIncisoi, cantIncisoJ:integer;

begin
       a:=nil; a2:=nil;  aF:= nil;  aG:=nil;
       max:= -1;
       min:=9999;
       cantidadPi:=0;
       cant:= 0;
       CargarArboles (a,a2);
       imprimirA2 (a2);
       max:= Maxi(a);
       writeln ('EL ISBN mas grande es: ', max); 
       min:= Mini(a2);
      writeln ('EL ISBN mas chico es: ', min); 
      writeln (' Ingrese un numero de socio para conocer el total de prestamos realizados: ');
       readln(numi);
       cantidadPi:=cantPrestamosi(a,numi);
       writeln (' La cantidad de prestamos realizada por el Socio: ', numi , ' es: ', cantidadPi);
       writeln (' Ingrese un numero de socio para conocer el total de prestamos realizados (estructura ii):  ');
       readln(numii);
      cant:=cantPrestamosii(a2,numii);
     writeln (' La cantidad de prestamos realizada por el Socio: ', numii , ' es: ', cant);
       cargarAF (a,aF);
       imprimirAF(aF);
       cargarAG(a2,aG);
       imprimirAG (aG);
       writeln ('Ingrese un ISBN: ');
       readln(isbn1);
       writeln('Ingrese el segundo ISBN (Mayor al primero): ');
       readln(isbn2);
       cantIncisoi:= Incisoi(a,isbn1,isbn2);
       writeln ('La cantidad de prestamos, entre: ', isbn1, ' y ', isbn2, ' son: ', cantIncisoi);      
        writeln ('Ingrese un ISBN (otro arbol 2): ');
       readln(isbn3);
       writeln('Ingrese el segundo ISBN (Mayor al primero): ');
       readln(isbn4);
       cantIncisoJ:= IncisoJ(a2,isbn3,isbn4);
       writeln ('La cantidad de prestamos, entre: ', isbn3, ' y ', isbn4, ' son: ', cantIncisoJ);
end.









