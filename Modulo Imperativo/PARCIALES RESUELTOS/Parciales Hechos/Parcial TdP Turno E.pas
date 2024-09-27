

program Castineira;
type 
   rangoGenero = 1..7;
   libro = record
        isbn:integer;   // FIN ISBN 0
        codigo:integer;
        genero:rangoGenero;
   end;
   
   libros = record
       codigo:integer;
       cant:integer;
   end;
   
  arbol = ^nodoArbol;
  nodoArbol = record
      dato:libros;
      HI:arbol;
      HD:arbol;
  end;
  
  genero = record 
      genero : rangoGenero;
      cant:integer;
 end; 
   vecGenero = array [rangoGenero] of genero;
   
   Procedure  inicializarV (var v:vecGenero);
   var i:integer;
   begin
       for i:= 1 to 7 do
       begin
             v[i].cant := 0;
               v[i].genero := 1;
       end;
   end;
   
   Procedure  leerLibro  (var l:libro);
   begin
        l.isbn := Random (101); 
        if (l.isbn <> 0) then
        begin
             l.codigo:= Random (100) + 1;
             l.genero:=Random (7)+1;
        end;
   end;
   
   procedure agregarArbol   (var a:arbol; codigo:integer);
   begin
         if ( a = nil) then
         begin
              new (a); a^.dato.codigo:=codigo;  a^.dato.cant:=1;  a^.HI:=nil; a^.HD:=nil
         end
         else if (codigo = a^.dato.codigo) then  a^.dato.cant:= 1 + a^.dato.cant
         else if (codigo < a^.dato.codigo) then agregarArbol (a^.HI,codigo)
         else agregarArbol (a^.HD,codigo);
   end;

 
   procedure cargarEstructuras  (var a:arbol; var v:vecGenero);
   var      l:libro; 
   begin
          leerLibro (l);
          while (l.isbn <> 0) do 
          begin
                 agregarArbol (a,l.codigo);
                 if (v[l.genero].cant = 0) then
                 begin
                        v[l.genero].cant :=  1;
                        v[l.genero].genero:= l.genero;
                end
                else  v[l.genero].cant :=  v[l.genero].cant + 1;
                 leerLibro (l);
          end;
   end;
   
   function incisoB (v:vecGenero):integer; 
   var   i,j:integer;  actual:genero;
   begin
         for i:= 2 to 7 do
         begin
              actual:=v[i]; 
              j:= i - 1;
              while  (j > 0) and  (v[j].cant < actual.cant)  do
              begin
                    v[j+1]:= v[j];
                    j:= j - 1;
              end;
              v[j + 1] := actual;
         end;
         incisoB := v[1].genero;
   end;
   
   function   incisoC  (a:arbol; codigo1,codigo2:integer):integer;
   begin
        if (a = nil) then incisoC := 0
        else if (codigo1 <= a^.dato.codigo) and (codigo2 >= a^.dato.codigo) then  incisoC := 1 + incisoC(a^.HI,codigo1,codigo2) + incisoC(a^.HD,codigo1,codigo2) 
        else if (codigo1 > a^.dato.codigo) then   incisoC :=  incisoC(a^.HD,codigo1,codigo2) 
        else    incisoC := incisoC(a^.HI,codigo1,codigo2)
   end;
   
   
   
   
   var  a:arbol;    v:vecGenero; B:integer;  codigo1,codigo2:integer; C:integer;
   
   begin
         Randomize;
         a:=nil;
         inicializarV (v);
         cargarEstructuras (a,v);
         B:=incisoB (v);
         writeln (B);
         writeln ('Ingrese Codigo 1: ');
         readln (codigo1);
         writeln ('Ingrese Codigo 2 (mayor al 1): ');
         readln (codigo2);
         C:= incisoC (a,codigo1,codigo2);
         writeln (' La cantidad total de codigos entre: ', codigo1, ' y ', codigo2, ' es: ', C);
   end.
       


