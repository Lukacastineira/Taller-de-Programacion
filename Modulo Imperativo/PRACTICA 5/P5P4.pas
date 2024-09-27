{
  4. Una oficina requiere el procesamiento de los reclamos de las personas. De cada reclamo
se ingresa código, DNI de la persona, año y tipo de reclamo. El ingreso finaliza con el
código de igual a 0. Se pide:


a) Un módulo que retorne estructura adecuada para la búsqueda por DNI. Para cada DNI
se deben tener almacenados cada reclamo y la cantidad total de reclamos que realizó.


b) Un módulo que reciba la estructura generada en a) y un DNI y retorne la cantidad de
reclamos efectuados por ese DNI.


c) Un módulo que reciba la estructura generada en a) y dos DNI y retorne la cantidad de
reclamos efectuados por todos los DNI comprendidos entre los dos DNI recibidos.


d) Un módulo que reciba la estructura generada en a) y un año y retorne los códigos de
los reclamos realizados en el año recibido.
}


program   p5p5;

type 

  reclamo = record
        codigo:integer;
        DNI:integer;
        anio:integer;
        reclamo:integer;
  end;
  
  reclamoL = record
      codigo:integer;
      anio:integer;
      Treclamo:integer;
  end;
  
  lista = ^nodo;
  nodo=record
    dato:reclamoL;
    sig:lista;
  end;
  
  reclamoN = record
    DNI:integer;
    cantR:integer;
  end;
  
  arbol = ^nodo1;
  nodo1 = record
     list:lista;
     dato:reclamoN;
     HI:arbol;
     HD:arbol;
  end;
  
  listaD = ^nodo2;
  nodo2 = record
    dato:integer;
    sig:listaD;
  end;
  
  PROCEDURE   leerReclamo  (var r:reclamo);
  begin
       writeln('Ingrese codigo de reclamo: ');
       readln(r.codigo);
       if (r.codigo  <> 0) then
       begin
           writeln('Ingrese DNI: ');
           readln(r.DNI);
           writeln('Ingrese año: ');
           readln(r.anio);
           writeln('Ingrese tipo de reclamo: ');
           readln(r.reclamo);
        end;
  end;   
  
  procedure  agregarAdelante  (var l:lista; r:reclamoL);
  var  nue:lista;
  Begin  
         new (nue);  nue^.dato:= r;  nue^.sig:= l;  l:= nue;
  end;
  
  procedure  InsertarArbol  (var a:arbol; r:reclamoN; rL:reclamoL);
  begin
       if (a= nil) then
       begin
          new(a); a^.dato:= r; a^.list:= nil; agregarAdelante(a^.list, rL);
          a^.dato.cantR:= 1;
          a^.HI:=nil; a^.HD:= nil; 
       end
       else  if (r.DNI = a^.dato.DNI) then  
       Begin
          agregarAdelante(a^.list,rL); 
          a^.dato.cantR:= a^.dato.cantR + 1;
       end
       else if (r.DNI  < a^.dato.DNI) then  InsertarArbol(a^.HI,r,rL)
       else  InsertarArbol(a^.HD,r,rL);
  end;
  
  procedure  pasarP  (r:reclamo;var DNI:integer; var rL:reclamoL);
  Begin
      DNI := r.DNI;
      rL.codigo:= r.codigo;
      rL.anio:= r.anio;
      rL.Treclamo:= r.reclamo;     
  end;
  
  procedure  cargarA  (var a:arbol);
  var  r:reclamo; rN:reclamoN;  rL:reclamoL;
  Begin
     leerReclamo (r);
     while (r.codigo  <> 0) do
     begin
         pasarP(r,rN.DNI,rL);
         InsertarArbol(a,rN,rL);
         leerReclamo(r);
     end;
   end;


function  incisoB  (a:arbol; dni:integer): integer;
begin
   if (a=nil) then incisoB:= 0
   else if (dni = a^.dato.DNI) then  incisoB:= a^.dato.cantR          ////  B)-------------------
   else if (dni < a^.dato.DNI) then  incisoB:= incisoB(a^.HI,dni)
   else  incisoB:= incisoB(a^.HD,dni);
end;


function  incisoC  (a:arbol;  dni1,dni2:integer): integer;
begin
    if (a=nil) then  incisoC:= 0
    else if (dni1 < a^.dato.DNI) and (dni2 > a^.dato.DNI) then incisoC:= a^.dato.cantR + incisoC(a^.HI,dni1,dni2) + incisoC(a^.HD,dni1,dni2)
    else  if (dni1 > a^.dato.DNI) then  incisoC:= incisoC(a^.HD,dni1,dni2)
    else  incisoC:= incisoC(a^.HI,dni1,dni2);
end;

procedure  agregarAD (var l:listaD; c:integer);
var  nue:listaD;
begin
    new(nue);  nue^.dato:= c;  nue^.sig:=l; l:=nue;
end;

procedure Lanios (l:lista; var lD:listaD; anio:integer);
var  aux:lista;
begin
    aux:=l;
    if (aux=nil) then  lD:= nil
    else  
    begin
    while  ( aux <> nil) do
    begin
       if (aux^.dato.anio = anio) then
          agregarAD(lD,aux^.dato.codigo);
       aux:= aux^.sig;
    end;
    end;
end;

procedure  incisoD (a:arbol; var lD:listaD; anio:integer);
begin
    if ( a <> nil) then
    Begin
       incisoD(a^.HI,lD,anio);
       Lanios (a^.list,lD,anio);
        incisoD(a^.HD,lD,anio);
    end;
end;         
   

var   a:arbol; dni,puntoB:integer;  dni1,dni2,puntoC:integer;   lD:listaD;  anio:integer;
begin
    a:=nil;
    
    cargarA (a);  ///  A)
    
    writeln ('Ingrese DNI (buscar reclamos): ');
    readln(dni);
    puntoB:= incisoB(a,dni);
    if ( puntoB = 0) then writeln ('No se encontraron reclamos del DNI: ', dni)
    else writeln ('La cantidad de reclamos realizados del DNI, ', dni , ' es: ', puntoB); 
    
    writeln ('Ingrese DNI 1 (buscar reclamos): ');
    readln(dni1);
    writeln ('Ingrese DNI 2 (mayor al DNI 1): ');
    readln(dni2);
    puntoC:= incisoC(a,dni1,dni2);
    if ( puntoC = 0) then writeln ('No se encontraron reclamos entre los DNI: ', dni1, ' y ', dni2)
    else writeln ('La cantidad de reclamos realizados entre los DNI, ', dni1 , ' y ', dni2, ' es: ', puntoC);   
    
    writeln ('Ingrese año para buscar u guardar todos los codigos de los reclamos de ese año');
    readln(anio);
    incisoD(a,lD,anio);
end.          
      
           
           
           
