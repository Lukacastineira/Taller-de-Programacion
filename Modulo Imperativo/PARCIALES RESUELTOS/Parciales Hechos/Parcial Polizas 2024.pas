program castineira;

type 
  rangoAnios = 2000..2023;
 poliza = record
     dni:integer;  // fin dni -1
     suma:integer;
     cuota:integer;
     vencimiento:rangoAnios;
end;

arbol = ^nodoArbol;
nodoArbol = record
    dato:poliza;
    HI:arbol;
    HD:arbol;
end;

polizaB = record
    dni:integer;
    suma:integer;
    cuota:integer;
end;

arbolB = ^nodoArbolB;
nodoArbolB = record
      dato: polizaB;
      HD:arbolB;
      HI:arbolB;
end;

vecPolizas = array [rangoAnios] of  arbolB;


    
procedure  leerPoliza  (var p:poliza);
begin
        writeln ('Ingrese DNI: ');
		readln(p.dni);
		if (p.dni <> -1) then
		   begin
		       p.suma := Random (9000-1000)+1000;
		       p.cuota := Random (500-100)+100;
		       p.vencimiento:= Random(2023-2000)+2000;
		   end;
end;

procedure   insertarArbol  (var a:arbol;  p:poliza);
begin
     
         if  (a = nil) then
         begin
             new (a);  a^.dato:=p;  a^.HI:=nil; a^.HD:=nil;
         end
         else if  ( p.suma < a^.dato.suma) then  insertarArbol (a^.HI,p)
         else   insertarArbol (a^.HD,p);
end;

procedure   CargarArbol   (var a: arbol);
var   p:poliza;
begin
    leerPoliza(p);
    while (p.dni  <> -1) do
    begin  
          insertarArbol (a,p);
          leerPoliza (p);
    end;
end;

procedure  inicializarV (var v:vecPolizas); 
var i:integer;
begin
   for i:= 2000 to 2023 do
   begin
         v[i] := nil;
   end;
end;

procedure   insertarArbolB  (var a:arbolB; p:polizaB);
begin
    if ( a = nil) then
    begin
        new (a);  a^.dato:= p; a^.HI:=nil; a^.HD:=nil;
    end
    else if ( p.dni < a^.dato.dni) then  insertarArbolB  (a^.HI,p)
    else  insertarArbolB  (a^.HD,p);
end;

procedure pasarP (var p:polizaB; dni,cuota,suma:integer);
begin
       p.dni:= dni;
       p.cuota:=cuota;
       p.suma:=suma;
end;

procedure  incisoB  (var v:vecPolizas; a:arbol; x:integer);
var   p:polizaB;
begin
   if (a <> nil) then
   begin
        if  ( x > a^.dato.suma) then
        begin 
             incisoB (v,a^.HI,x);
            incisoB(v,a^.HD,x); 
            pasarP(p,a^.dato.dni,a^.dato.cuota,a^.dato.suma);
            insertarArbolB (v[a^.dato.vencimiento],p);
        end
        else if (x <= a^.dato.suma) then  incisoB (v,a^.HI,x);
   end;
end; 
   function recorroAB (a:arbolB; dni:integer):integer;
begin
        if (a = nil) then  recorroAB:= 0
        else if  ( dni  =  a^.dato.dni) then  recorroAB := 1 +  recorroAB(a^.HD, dni)
        else if (dni < a^.dato.suma) then  recorroAB :=  recorroAB (a^.HI,dni)
        else     recorroAB :=   recorroAB (a^.HD,dni);
end;  
   
   function  incisoC  (v:vecPolizas; dni:integer): integer;
   var i:integer; 
   begin  
        incisoC:=0;
        for  i:= 2000 to 2023 do
        begin
              incisoC := incisoC + recorroAB (v[i],dni);
        end;
  end;
  
  procedure imprimirA  (a:arbol ) ;
  begin
      if (a<>nil) then
         begin
              imprimirA (a^.HI);
                  writeln ('|-------------------------------------|');
               writeln ('El dni de la poliza es: ', a^.dato.dni);
               writeln ('La suma de la poliza es: ', a^.dato.suma);
               writeln ('La cuota de la poliza es: ', a^.dato.cuota);
                writeln ('El vencimientio de la poliza es: ', a^.dato.vencimiento);
                    writeln ('|-------------------------------------|');
                   imprimirA (a^.HD);
         end;
   end;      
 procedure imprimirAB  (a:arbolB ) ;
  begin
      if (a<>nil) then
         begin
              imprimirAB (a^.HI);
               writeln ('El dni de la poliza es: ', a^.dato.dni);
               writeln ('La suma de la poliza es: ', a^.dato.suma);
               writeln ('La cuota de la poliza es: ', a^.dato.cuota);
               imprimirAB (a^.HD);
         end;
   end;      
  Procedure  imprimirV (v:vecPolizas);
  var i:integer;
  begin
      for i := 2000 to 2023 do
      begin
            writeln ('|-------------------------------------|');
            writeln ('El anio de vencimiento es: ', i); 
            writeln ('|-------------------------------------|');
            imprimirAB (v[i]); 
            writeln ('|-------------------------------------|');
      end;
  end;
  var   a:arbol;  v:vecPolizas;  sumaB:integer;  dniC:integer;  polizasDni:integer;
   begin
        a:=nil;
        inicializarV(v);
        CargarArbol (a);
        imprimirA(a);
        writeln ('Ingrese suma para guardar las polizas menores a ese valor. ');
        readln(sumaB);
        incisoB (v,a,sumaB);
         imprimirV(v);
         writeln ('Ingrese DNI para contar su total de polizas . ');
       readln (dniC);
         polizasDni := incisoC (v,dniC);
       writeln (polizasDni);
   end.
                   
                
                
                
                
                
                
                
                
                
                
                

		       
		       
