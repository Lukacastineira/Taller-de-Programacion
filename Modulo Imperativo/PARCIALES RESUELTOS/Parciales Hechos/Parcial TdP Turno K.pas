

program Castineira;


type
     rangoGenero = 1..15;
libro = record
    isbn: integer;     // FIN ISBN 0
    anio:integer;
    autor:integer;
    genero:rangoGenero
end;

libroL = record
      isbn:integer;
      anio:integer;
      genero:rangoGenero;
end;

lista = ^nodoLista;
nodoLista = record
        dato:libroL;
        sig:lista;
end;

librosArbol = record
       autor:integer;
       list:lista;
end;

arbol = ^nodoArbol;
nodoArbol = record
        dato:librosArbol;
        HI:arbol;
        HD:arbol;
end;
   
librosB = record
   autor:integer;
   cant:integer;
end;

listaB = ^nodoListaB;
nodoListaB = record
   dato:librosB;
   sig:listaB;
end;    

Procedure   leerLibro   (var l:libro);
begin
       l.isbn := Random (100);
       if (l.isbn <> 0 ) then
       begin
             l.anio:= Random (2024-1940)+1940;
             l.Autor := Random (100) + 1;
             l.Genero:=  Random (15) + 1;
       end;
end;

procedure   agregarAdelante  (var l:lista; li:libroL);
var nue:lista;
begin
       new (nue);  nue^.dato:= li; nue^.sig:=l;  l:=nue;
end;
  
procedure  agregarArbol  (var a:arbol; li:libroL; autor:integer ); 
begin
      if (a = nil) then 
      begin
           new (a); a^.dato.autor:= autor; a^.dato.list:=nil;
           agregarAdelante (a^.dato.list,li);
           a^.HD:= nil ;  a^.HI := nil;
      end
      else if   (autor = a^.dato.autor) then  agregarAdelante (a^.dato.list, li)
      else if (autor < a^.dato.autor) then  agregarArbol (a^.HI,li,autor)
      else  agregarArbol (a^.HD,li,autor);
end;     

procedure  pasarP  (var l:libroL; isbn,anio:integer; genero:rangoGenero);
begin
       l.isbn := isbn;
       l.anio:= anio;
       l.genero:= genero;
end;
     
procedure cargarEstructura  (var a:arbol);
var    li:LibroL; l:libro;
begin
      leerLibro (l);
      while  (l.isbn <> 0) do
      begin
             pasarP (li,l.isbn,l.anio,l.genero);
             agregarArbol(a,li,l.autor);
             leerLibro(l);
      end;
end;     

procedure   agregarAdelanteB  (var l:listaB; li:librosB);
var nue:listaB;
begin
       new (nue);  nue^.dato:= li; nue^.sig:=l;  l:=nue;
end;

function contarL  (l:lista):integer;
var  aux:lista;
begin
      aux:=l; contarL:=0;
      while (aux <> nil) do
      begin
           contarL := contarL + 1;
           aux:= aux^.sig;
      end;
end;

procedure  incisoB  (a:arbol;  codigo:integer; var l:listaB); 
var   cant:integer;  li:librosB;
begin
      if ( a <> nil ) then
      begin
             if (codigo < a^.dato.autor) then
               begin
                     cant:=contarL(a^.dato.list);  
                     li.cant:= cant;
                     li.autor:=a^.dato.autor;
                     agregarAdelanteB(l,li);
                     incisoB(a^.HD,codigo,l);
                     incisoB(a^.HI,codigo,l);
               end
               else if (codigo >= a^.dato.autor) then incisoB (a^.HD,codigo,l);
      end;
end;
     
procedure   incisoC (l:listaB; var maxCant:integer;  var maxAutor:integer);
begin
      if ( l <> nil) then
      begin
            if ( maxCant < l^.dato.cant) then
            begin
                  maxCant := l^.dato.cant;
                  maxAutor:= l^.dato.autor;
                  incisoC(l^.sig, maxCant,maxAutor);
            end
            else incisoC (l^.sig,maxCant,maxAutor);
      end;
end;
     
procedure   imprimirL (l:lista);
var aux:lista;
begin
     aux:=l;
     while (aux <> nil) do
     begin
           writeln ('|----------------------------');
           writeln ('ISBN: ',aux^.dato.isbn);
           writeln ('Anio: ',aux^.dato.anio);
           writeln ('Genero: ',aux^.dato.genero);
           writeln ('|----------------------------');
           aux:=aux^.sig;
     end;
end;

procedure  imprimirA (a:arbol);
begin
    if (a <> nil) then
    begin
          imprimirA (a^.HD);
          writeln ('|////////////////////////////////////|');
          writeln ('Autor: ', a^.dato.autor);
          writeln ('|----------------------------');
          imprimirL (a^.dato.list);
         writeln ('|////////////////////////////////////|');
          imprimirA(a^.HI);
    end;
end;

procedure   imprimirLB (l:listaB);
var aux:listaB;
begin
     aux:=l;
     while (aux <> nil) do
     begin
           writeln ('||||||||||||||||||||||||||||||||||||||');
           writeln ('Cant: ',aux^.dato.cant);
           writeln ('Autor: ',aux^.dato.autor);
           writeln ('||||||||||||||||||||||||||||||||||||||');
           aux:=aux^.sig;
     end;
end;
var  a:arbol;  codigo:integer; l:listaB;  maxC,maxA :integer;
begin
      Randomize;
      a:=nil; l:=nil;   maxC := -1; maxA:=0;
      cargarEstructura (a);
      imprimirA(a);
      readln(codigo);
      incisoB (a,codigo,l);
      imprimirLB (l);
      incisoC(l,maxC,maxA);
      writeln ('cant max: ',maxC);
      writeln('max Autor: ',maxA);
end.  
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
