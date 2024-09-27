{
2. Una agencia dedicada a la venta de autos ha organizado su stock y, tiene la información de
los autos en venta. Implementar un programa que:
a) Genere la información de los autos (patente, año de fabricación (2010..2018), marca y
modelo, finalizando con marca ‘MMM’) y los almacene en dos estructuras de datos:


i. Una estructura eficiente para la búsqueda por patente.


ii. Una estructura eficiente para la búsqueda por marca. Para cada marca se deben
almacenar todos juntos los autos pertenecientes a ella.


b) Invoque a un módulo que reciba la estructura generado en a) i y una marca y retorne la
cantidad de autos de dicha marca que posee la agencia.


c) Invoque a un módulo que reciba la estructura generado en a) ii y una marca y retorne
la cantidad de autos de dicha marca que posee la agencia.


d) Invoque a un módulo que reciba el árbol generado en a) i y retorne una estructura con
la información de los autos agrupados por año de fabricación.


e) Invoque a un módulo que reciba el árbol generado en a) i y una patente y devuelva el
modelo del auto con dicha patente.


f) Invoque a un módulo que reciba el árbol generado en a) ii y una patente y devuelva el
modelo del auto con dicha patente.

   
}

program  P5P2;
CONST
       minA=2010; maxA=2018;
TYPE 
        rangoA= minA..maxA;  MS=string[15];
        auto = record
           patente:integer;
           anio: rangoA;
           marca:MS; 
           modelo:MS;
        end;
        
        arbol1=^nodo1;
        nodo1=record
           dato:auto;
           HI:arbol1;
           HD:arbol1;
        end;
        
        autoL = record
           patente:integer;
           anio: rangoA;
           modelo:MS;
        end;
        
        lista=^nodo;
        nodo=record
          dato:autoL;
          sig:lista;
        end;
        
        arbol2=^nodo2;
        nodo2=record
            list:lista;
            marca:MS;
            HI:arbol2;
            HD:arbol2;
        end;
        
   Procedure CargarAuto (var a: auto);
  var vMarcas:array [0..10] of string= ('Ford', 'Volkswagen', 'Toyota', 'Honda', 'Nissan', 'Seat', 'Chevrolet', 'Dodge', 'Peugeot', 'Audi', 'mmm'); 
  
  vModelos:array [0..9] of string= ('Goltrend', 'Focus', 'Corolla', 'Civic', 'GTR', 'LeonCupra', 'Camaro', 'Hellcat', 'RCZ', 'RS3'); 
  
  begin
    a.marca := vMarcas[random(11)];
    If (a.marca <> 'mmm')
    then begin
           a.modelo:= vModelos[random(10)];
          a.anio:= random (maxA-minA)+minA;
          a.patente:= random(1000-500)+500;
         end;
  end;  

procedure agregarAdelante ( var l:lista; aL:autoL);
var  nue:lista;
begin
     new(nue);  nue^.dato:=aL;  nue^.sig:=l; l:=nue;
end;

 procedure InsertarA1 (var a:arbol1;  aut:auto);
 begin
      if (a=nil) then
         begin
              new(a); a^.dato:= aut;  a^.HI:=nil; a^.HD:=nil;
         end
         else if ( aut.patente < a^.dato.patente) then  InsertarA1 (a^.HI,aut)
         else  InsertarA1 (a^.HD,aut);       
end;

procedure InsertarA2 (var a2:arbol2; marca:MS; aL:autoL);
begin
      if (a2=nil) then  
        begin
              new(a2); a2^.marca:= marca;  a2^.list:=nil;
              agregarAdelante(a2^.list,aL);
              a2^.HI:=nil; a2^.HD:=nil;
        end
        else if (marca = a2^.marca) then agregarAdelante(a2^.list,aL)
        else if (marca < a2^.marca) then  InsertarA2 (a2^.HI,marca, aL)
        else InsertarA2 (a2^.HD,marca, aL)
end;


procedure pasarDatos   (var aL:autoL;  modelo:MS; patente:integer; anio:rangoA);
Begin
        aL.patente:=patente;
        aL.anio:=anio;
        aL.modelo:=modelo;
end;

procedure CargarArboles (var a:arbol1; var a2:arbol2);
var   aut:auto; aL:autoL; 
begin
      CargarAuto (aut);
      while  (aut.marca <> 'mmm') do
      begin                                                                                                                       /////       A)    i  y   ii --------------------------------------------
            InsertarA1(a,aut);
            pasarDatos(aL,aut.modelo, aut.patente, aut.anio);
            InsertarA2(a2,aut.marca,aL);
            CargarAuto(aut);
      end;        
end;

function   cantAutosMarcai  (a:arbol1; m:MS) :  integer;
begin
    if(a=nil) then  cantAutosMarcai:= 0                                                                                     /////            B)---------------------------------------------------------
    else if (m = a^.dato.marca) then  cantAutosMarcai:= 1 + cantAutosMarcai(a^.HD,m) + cantAutosMarcai(a^.HI,m)
    else   cantAutosMarcai:= cantAutosMarcai(a^.HD,m) + cantAutosMarcai(a^.HI,m);
 end;   

function   contarP (l:lista): integer;
var aux:lista;
begin
       aux:=l;
       if (aux=nil) then  contarP:= 0
       else 
       begin
       while (aux<>nil)  do
       begin  
              contarP:= 1 + contarP;
              aux:=aux^.sig;
       end;
       end;
end;

function   cantAutosMarcaii (a2:arbol2;  m2:MS): integer;
begin
       if (a2=nil) then  cantAutosMarcaii:=0
       else if   (m2 = a2^.marca) then  cantAutosMarcaii:= contarP(a2^.list)                              ////    C)--------------------------------------------------------------------
       else  if  (m2 > a2^.marca) then  cantAutosMarcaii:=cantAutosMarcaii(a2^.HD,m2) 
       else  cantAutosMarcaii:=cantAutosMarcaii(a2^.HI,m2);
end;

procedure InsertarAD (var aD:arbol1;  aut:auto);
 begin
      if (aD=nil) then
         begin
              new(aD); aD^.dato:= aut;  aD^.HI:=nil; aD^.HD:=nil;
         end
         else if ( aut.anio < aD^.dato.anio) then  InsertarAD (aD^.HI,aut)
         else  InsertarAD (aD^.HD,aut);       
end;


procedure  agregarAD ( a:arbol1;  var aD:arbol1);
begin
       if (a<>nil) then
       begin
              agregarAD (a^.HI,aD);
              InsertarAD (aD, a^.dato);                                                                                       ////    D)----------------------------------------------------------------------------
              agregarAD (a^.HD,aD);
       end;
end;

function   modeloA1  (a:arbol1; patente:integer) : MS;
begin
       if (a = nil) then  modeloA1:= 'pii'
       else if (patente = a^.dato.patente) then  modeloA1:= a^.dato.modelo
       else  if (patente < a^.dato.patente) then modeloA1:= modeloA1(a^.HI,patente)           ////////  E)--------------------------------------------------------------------------
       else   modeloA1:= modeloA1(a^.HD,patente);
end;

function  buscarP   (l:lista; patente:integer): MS; 
var aux:lista;
begin
       aux:=l;
       if (aux = nil) then    buscarP:= 'pii' 
       else 
       begin 
         while  (aux<>nil) and (patente <> aux^.dato.patente) do
         begin
                 aux:=aux^.sig;
         end;
          if (aux <> nil) and (patente = aux^.dato.patente) then 
                  buscarP:= aux^.dato.modelo;
       end;
end;   

function    modeloA2 (a2:arbol2; patente:integer): MS;
begin
      if (a2= nil) then  modeloA2:= 'pii'
      else if (a2<>nil) then
      begin
             modeloA2:= modeloA2(a2^.HI, patente);
             modeloA2:= modeloA2(a2^.HD, patente);
             modeloA2:= buscarP(a2^.list,patente);
      end;
end;       

procedure imprimirA1 (a:arbol1);
begin
       if(a<>nil) then
            begin
                imprimirA1(a^.HI);
                 writeln('La marca del auto es: ', a^.dato.marca);
                  writeln('El modelo del auto es: ', a^.dato.modelo);                                    
                   writeln('La patente del auto es: ', a^.dato.patente);
                    writeln('El anio del auto es: ', a^.dato.anio);
                    imprimirA1(a^.HD);
             end;
end;

var  a1:arbol1;  a2:arbol2; marca1,marca2:MS; cant1,cant2:integer;  aD:arbol1;  patente1,patente2:integer;  modelo1,modelo2:MS;

begin
        a1:= nil; a2:=nil; aD:=nil;
        randomize;
       CargarArboles(a1, a2);
       
       imprimirA1(a1);
       
       writeln ('Ingrese marca para buscar cantidad de autos de la misma: ');
       readln(marca1);
       cant1:= cantAutosMarcai(a1,marca1);
       if (cant1 = 0) then writeln ('No se encontraron autos de dicha Marca. ')
       else      writeln ('La cantidad de autos de la marca. ', marca1, ' es: ', cant1);
       
        writeln ('Ingrese marca para buscar cantidad de autos de la misma (arbol2 2): ');
       readln(marca2);
       cant2:= cantAutosMarcaii(a2,marca2);
       if (cant2 = 0) then writeln ('No se encontraron autos de dicha Marca. ')
       else      writeln ('La cantidad de autos de la marca. ', marca2, ' es: ', cant2);
       
       agregarAD(a1,aD);
       imprimirA1(aD);
       
        writeln ('Ingrese Patente a buscar: ');
       readln(patente1);
       modelo1:= modeloA1 (a1,patente1);
       if (modelo1 = 'pii' ) then writeln ('No se encontro la patente. ')
       else      writeln ('El modelo de auto con patente: ', patente1, ' es: ', Modelo1);
       
        writeln ('Ingrese Patente a buscar  (arbol2 2): ');
        readln(patente2);
        modelo2:=  modeloA2(a2,patente2);
        if (modelo2 = 'pii' ) then writeln ('No se encontro la patente. ')
        else      writeln ('El modelo de auto con patente: ', patente2, ' es: ', Modelo2);
end.



















      


