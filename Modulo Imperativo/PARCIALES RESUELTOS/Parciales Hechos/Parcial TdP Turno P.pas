

program castineria;

type 
    rangoCategoria = 1..5;
    compra = record
         comida:integer;
         cliente:integer;
         categoria:rangoCategoria;
    end;
    
    compraA = record
       comida:integer;
       entregas:integer;
    end;
    
    arbol = ^nodo; 
    nodo = record
       dato: compraA;
       HI:arbol;
       HD:arbol;
    end;

    vecCategoria = array  [rangoCategoria] of  integer;
    
    procedure leerCompra (var c:compra);
    begin
          c.cliente := Random(200);
          if (c.cliente <> 0) then
          begin
               c.comida:= Random   (200) + 1000; 
               c.categoria :=  Random (5) + 1;
          end;
    end;
    
    procedure inicilizarV (var v:vecCategoria);
    var i:integer;
    begin
         for i := 1 to 5 do 
         begin
              v[i] := 0; 
         end;
    end;
    
    procedure  agregarArbol  (var a:arbol;  comida:integer);
    begin
         if (a = nil) then
         begin
               new(a); a^.dato.comida:=comida; a^.dato.entregas:= 1;
               a^.HI:=nil; a^.HD:=nil;
         end
         else if  ( comida = a^.dato.comida) then  a^.dato.entregas := a^.dato.entregas + 1
         else if (comida < a^.dato.comida) then  agregarArbol (a^.HI,comida)
         else   agregarArbol (a^.HD,comida);
     end;
     
     
     procedure CargarEstructuras (var a:arbol; var v:vecCategoria);
     var   c:compra;
     begin
          leerCompra (c);
          while (c.cliente <> 0) do
          begin
               agregarArbol (a,c.comida);
               v[c.categoria]  :=   v[c.categoria]   +   1;
               leerCompra (c);
          end;
    end;
    
    function  incisoB (a:arbol; codComida:integer): integer;
    begin
          if (a = nil) then incisoB := 0
          else if  ( codComida = a^.dato.comida) then  incisoB:= a^.dato.entregas
          else if  ( codComida < a^.dato.comida) then incisoB:= incisoB (a^.HI,codComida)
          else  incisoB:= incisoB (a^.HD,codComida);
    end;
    
    procedure ordenarV  ( var v:vecCategoria; var MaxCategoria:integer ); 
    var    i,j:integer; actual:integer;
    begin
         for i := 2 to 5 do
         begin
            actual:= v[i];
             j:= i -1; 
             while (j > 0) and (v[j] > actual) do
             begin
                  v[j+1] := v[j];
                  j:= j  - 1;
             end;
                v[j+1] := actual;
        end;    
        MaxCategoria := v[5] ;
   end;       
   
   procedure imprimirV (v:vecCategoria);
   var i :integer;
   begin
        for i:= 1 to 5 do
        begin
             writeln ('La cantidad de entregas de la categoria ', i ,  ' es: ', v[i]);
        end;
   end;
   
   procedure imprimirArbol  ( a :arbol) ;
   begin
        if (a<>nil)then
        begin
             imprimirArbol (a^.HI);
             writeln ('|------------------------------------------------------------|');
             writeln ('El codigo de comida es ', a^.dato.comida);
             writeln ('La cantidad de entregas es ', a^.dato.entregas);
              writeln ('|-----------------------------------------------------------|');
             imprimirArbol (a^.HD);
        end;
   end;
   
   var a:arbol; v:vecCategoria; comida, cantEntregasCod,MaxCategoria:integer; 
   begin
        Randomize;
         a:=nil; MaxCategoria:= 0;
         inicilizarV(v);
        CargarEstructuras (a,v);
          imprimirArbol (a);
        imprimirV (v);
        readln (comida);
        cantEntregasCod:=incisoB (a,comida);
        writeln ('La cantidad de entregas del  codigo de comida: ',comida, ' es: ', cantEntregasCod);
        ordenarV (v,MaxCategoria); 
        writeln (' La categoria con mayor cantidad de entregas ', MaxCategoria);
    end.
    
    
    
    
    
    
    
    
    
