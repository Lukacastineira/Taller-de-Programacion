{
3.- Netflix ha publicado la lista de películas que estarán disponibles durante el mes de
diciembre de 2022. De cada película se conoce: código de película, código de género (1: acción,
2: aventura, 3: drama, 4: suspenso, 5: comedia, 6: bélico, 7: documental y 8: terror) y puntaje
promedio otorgado por las críticas.
Implementar un programa que invoque a módulos para cada uno de los siguientes puntos:

a. Lea los datos de películas, los almacene por orden de llegada y agrupados por código de
género, y retorne en una estructura de datos adecuada. La lectura finaliza cuando se lee el
código de la película -1.


b. Genere y retorne en un vector, para cada género, el código de película con mayor puntaje
obtenido entre todas las críticas, a partir de la estructura generada en a)..


c. Ordene los elementos del vector generado en b) por puntaje utilizando alguno de los dos
métodos vistos en la teoría.


d. Muestre el código de película con mayor puntaje y el código de película con menor puntaje,
del vector obtenido en el punto c).   
}

PROGRAM P1P3;

 
TYPE
     rangoG=1..8;
    pelicula = record
        codigoP:integer;
        codigoGenero: rangoG;
        puntaje:real;
    end;
    lista=^nodo;
    nodo=record               //a. Lea los datos de películas, los almacene por orden de llegada y agrupados por código de género, 
      dato:pelicula;
      sig:lista;            //y retorne en una estructura de datos adecuada. La lectura finaliza cuando se lee el código de la película -1.
    end;
    peli=record
      punt:real;
      codigoPeli:integer;
    end;
    
    vectorpuntajes = array [1..8] of peli;
procedure inicializarL (VAR l: lista);
begin
   l:=nil;
end;

procedure inicializarpuntajes (var v:vectorpuntajes);
var i: integer;
begin
 for i:= 1 to 8 do 
 begin
   v[i].punt:= 0;
   v[i].codigoPeli := 0;
 end;
end;

procedure  leerPelicula (var p:pelicula);
begin
    writeln ('Ingrese Copdigo de pelicula: ');
    readln(p.codigoP);
    if (p.codigoP <> -1) then 
    begin
        writeln ('Ingrese Copdigo de genero: ');
        readln(p.codigoGenero);
        writeln ('Ingrese puntaje promedio: ');
        readln (p.puntaje);
    end;
end;

procedure ingresarOrdenado (var l:lista; p:pelicula);
var 
  act,ant,nue:lista;  
begin
   new(nue);
   nue^.dato:=p;
   act:=l;
   ant:=l;
   while (act <> nil) and (act^.dato.codigoGenero > p.codigoGenero) do 
   begin
       ant := act;
       act := act^.sig;
    end;
    if (ant = act) then
        l:=nue
    else
      ant^.sig:= nue;
    nue^.sig:= act;
end; 

procedure generarL (var l:lista);
var  p:pelicula;
begin
    leerPelicula (p);
    while (p.codigoP <> -1) do
    begin
        ingresarOrdenado (l,p);
        leerPelicula(p);
    end;
end;

procedure imprimirL (l:lista);
begin
    while (l<> nil) do 
    begin
        writeln('el codigo de pelicula es: ', l^.dato.codigoP);
        writeln('el codigo de genero es: ' , l^.dato.codigoGenero);
        writeln('el puntaje promedio es: ' , l^.dato.puntaje);            //b. Genere y retorne en un vector, para cada género, el código de película con mayor puntaje                    
        l:=l^.sig;                                                       // obtenido entre todas las críticas, a partir de la estructura generada en a)..
    end;
end;

procedure recorrolista (l:lista; var v:vectorpuntajes);
var   max:real;  generoactual:integer; codigomax: integer;
begin
  while (l<>nil) do  
  begin
    generoactual:= l^.dato.codigoGenero;
    max:= 0; codigomax:= 0;
    while (l<>nil) and ( generoactual = l^.dato.codigoGenero) do
      begin
        if (l^.dato.puntaje > max) then
        begin
           max:= l^.dato.puntaje;
           codigomax:= l^.dato.codigoP;
        end;
        v[generoactual].punt:=max;
        v[generoactual].codigoPeli:= codigomax;       
        l:= l^.sig;
      end;
  end;
end;
procedure ordenacionV (var v:vectorpuntajes);  // c. Ordene los elementos del vector generado en b) por puntaje utilizando alguno de los dos métodos vistos en la teoría.   
var  i,j:integer;  pos:peli;
begin
    for i:= 2 to 8 do 
    begin
      j:=1; 
      pos:=v[i];
      j:=i-1;
      while (j>0) and (v[j].punt>pos.punt) do
      begin
          v[j+1]:= v[j];
          j:=j-1;
      end;
      v[j+1]:= pos;
    end;
end;      
  
var  l:lista; v:vectorpuntajes; var i:integer;
begin
     inicializarL(l);
     inicializarpuntajes (v);
     generarL(l);
     //imprimirL(l);
     recorrolista(l,v);
     ordenacionV(v);
     for i:= 1 to 8 do 
     begin
       writeln ('el puntaje maximo del genero: ', i , ' es: ', v[i].punt)
     end;
     writeln ('el codigo de pelicula con mayor puntaje es: ', v[8].codigoPeli , ' y el de menor puntaje es: ', v[1].codigoPeli);
end.
