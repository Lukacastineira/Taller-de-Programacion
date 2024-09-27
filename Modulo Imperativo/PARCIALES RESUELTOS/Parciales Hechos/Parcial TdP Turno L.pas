
program Castineira;

type
     meses = 1..12;
    compra = record 
       cliente:integer;  // FIN CLIENTE 0
       factura:integer;
       mes:meses;
       monto:real;
    end;
    
    vecMontos = array [meses] of real;
    
    compraA = record
         vec:vecMontos;
         cliente:integer;
    end;
    
    arbol = ^nodoArbol;
    nodoArbol = record
       dato:compraA;
       HD:arbol;
       HI:arbol;
    end;
    
    procedure  leerCompra  (var c: compra);
    begin
           c.cliente := Random (100);
           if (c.cliente <> 0) then
           begin
                  c.factura := Random (1000-500)+500;
                  c.mes := Random (12)+1;
                  c.monto := Random (9000)+1 /  (Random(4)+1);
           end;
    end;
    
    procedure inicializarV  (var v:vecMontos);
    var i:integer;
    begin
         for i := 1 to 12 do
         begin
              v[i] := 0;
         end;
    end;
    
    
    procedure  agregarArbol  (var a:arbol; cliente:integer; monto:real; mes:meses);
    begin
          if (a = nil ) then
          begin
                new (a); a^.dato.cliente:= cliente; inicializarV (a^.dato.vec); a^.dato.vec[mes]:= monto;
                a^.HD:=nil; a^.HI:=nil;
          end
          else if (cliente = a^.dato.cliente) then   a^.dato.vec[mes] := a^.dato.vec[mes] + monto
          else if (cliente < a^.dato.cliente) then agregarArbol (a^.HI,cliente,monto,mes)
          else agregarArbol (a^.HD,cliente,monto,mes);
    end;
    
    procedure cargarEstructura  (var a:arbol);
    var   c:compra;  
    begin
          leerCompra (c);
          while (c.cliente <> 0) do
          begin
                agregarArbol (a,c.cliente,c.monto,c.mes);
                leerCompra(c);
          end;
    end;

   function   maxMes  (v:vecMontos):integer;
   var i :integer;  max:real;
   begin
          maxMes := 0;  max:=0;
          for i := 1 to 12 do
          begin
                if (max < v[i]) then 
                begin
                    max:= v[i];
                    maxMes:= i;
                end;
          end;
   end;
   
   function  incisoB (a:arbol; cliente:integer):integer;
   begin
        if (a = nil) then incisoB:=0
        else if (cliente = a^.dato.cliente) then incisoB:= maxMes (a^.dato.vec)
        else if (cliente < a^.dato.cliente) then incisoB:= incisoB (a^.HI,cliente)
        else   incisoB:= incisoB (a^.HD,cliente);
   end;
   
function incisoC (a:arbol; mes:meses):integer;
begin
     if (a = nil) then incisoC:=0
     else if ( a <> nil) then
     begin
             if (a^.dato.vec[mes] = 0) then incisoC:= 1 + incisoC (a^.HI,mes) + incisoC(a^.HD,mes) 
             else
             begin
                 incisoC:= incisoC (a^.HI,mes) +  incisoC (a^.HD,mes);
             end;
     end;
end;

procedure imprimirV (v:vecMontos);
var i:integer;
begin
      for i:= 1 to 12 do
      begin
           writeln ('El monto del mes: ', i , ' es: ', v[i]:0:2) ;
      end;
end;

procedure imprimirA (a:arbol);
begin
       if (a <> nil) then
       begin
            imprimirA (a^.HI);
            writeln ('|\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\|');
            writeln ('Codigo de Cliente: ',a^.dato.cliente);
            writeln ('|\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\|');
            imprimirV (a^.dato.vec);
            writeln ('|--------------------------------------------|');
            imprimirA (a^.HD);
       end;
end;

var   a:arbol;  cliente,maxM:integer;  mes:meses; cantClientes:integer;
begin
      Randomize;
      a:=nil;
      cargarEstructura (a);
      imprimirA(a);
      readln (cliente);
      maxM:=incisoB (a,cliente);
      writeln (maxM);
      readln(mes);
      cantClientes := incisoC(a,mes);
      writeln (cantClientes);
end.






