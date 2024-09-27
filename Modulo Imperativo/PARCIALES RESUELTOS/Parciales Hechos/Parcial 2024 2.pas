{Un supermercado quiere llevar un registro de todas sus ventas, de cada venta se lee el codigo, dni del cliente, 
suscursal en la que compró (1..5) y monto gastado, la lectura se detiene con el código de venta 0, se pide:

A- crear una estructura eficiente para la busqueda por dni de cliente, de cada cliente se guarda el monto gastado en cada sucursal

B-un módulo que reciba la estructura generada en A y un número de sucursal y
 retorne la cantidad de clientes que no gastaron nada en la sucursal

C-un modulo que reciba la estructura generara en A y un dni y 
retorne el monto total general gastado por dicho dni (es decir, la suma de los montos de todas las sucursales)
}



program   castineira;   


type 
     rangoSucursal = 1..5;
  venta = record 
     codigo:integer;           //  FIN CODIGO DE VENTA 0
     dni:integer;
     sucursal:rangoSucursal;
     monto:real;
  end;
 
  vecCliente = array [rangoSucursal] of   real; 
  
  regCliente = record 
       dni:integer;
       vector:vecCliente;
  end;
  
  arbol = ^nodoArbol;
  nodoArbol = record 
     dato:regCliente;
     HI:arbol;
     HD: arbol;
  end;
  
  
  procedure  leerVenta   (var v:venta);
  begin
        readln(v.codigo);
        if (v.codigo <> 0) then
        begin
             v.dni := Random (99-10) + 10;
             readln(v.sucursal);
             v.monto:= Random (9999)+1/ (Random(5)+1); 
        end;
end;

procedure  inicializarV  (var v:vecCliente);
var i:integer;
begin
    for i := 1 to 5 do
    begin
           v[i] := 0;
    end; 
end;

procedure insertarA  (var a:arbol; dni:integer; monto: real; sucursal:rangoSucursal);
begin
   if (a = nil) then
   begin
          new (a); a^.dato.dni:= dni;  inicializarV(a^.dato.vector);   a^.dato.vector[sucursal]:= monto; 
   end
   else if (dni = a^.dato.dni) then  a^.dato.vector[sucursal] := a^.dato.vector[sucursal] + monto
   else if  (dni < a^.dato.dni) then insertarA (a^.HI,dni,monto,sucursal)
   else  insertarA (a^.HD,dni,monto,sucursal);
end;

procedure   cargarArbol  (var a:arbol);
var    v:venta; 
begin
      leerVenta(v);
      while (v.codigo <> 0 ) do
      begin
            insertarA (a,v.dni,v.monto,v.sucursal);
            leerVenta(v);
      end;                             // B-un módulo que reciba la estructura generada en A y un número de sucursal y  retorne la cantidad de clientes que no gastaron nada en la sucursal
end;

           
Function    incisoB   (a:arbol; num:integer): integer;
begin
           if (a=nil) then incisoB:=  0       
           else  if (a^.dato.vector[num] = 0) then  incisoB:= 1 + incisoB (a^.HI,num) +  incisoB (a^.HD,num)
           else  incisoB:=  incisoB (a^.HI,num) +  incisoB (a^.HD,num);                                  
end;         
   
function   sumaMontos (v:vecCliente): real;
var i:integer;
begin 
     sumaMontos:= 0;
     for i := 1 to 5 do
     begin
          sumaMontos:= sumaMontos + v[i]; 
     end;
end;


function  incisoC (a:arbol; dni:integer):real;
begin
       if  ( a= nil) then  incisoC:= 0
       else  if  (dni = a^.dato.dni) then incisoC:= sumaMontos(a^.dato.vector)
       else if (dni < a^.dato.dni) then  incisoC := incisoC (a^.HI,dni)
       else  incisoC := incisoC (a^.HD,dni);
end;

var  a:arbol;   sucursal,clientesNada:integer;   dni:integer; montoTotal:real;
begin 
      a:=nil;
      randomize;
      cargarArbol (a);
      writeln ('Ingrese Numero de Sucursal, para retornar cantidad de clientes los cuales no gasataron nada en dicha scursal: ');
      readln (sucursal);
      clientesNada:=incisoB (a,sucursal);
      writeln ('La cantidad de clientes los cuales no gasataron nada en la scursal: ', sucursal, ' es: ', clientesNada);
      writeln('Ingrese DNI para conocer el monto total gastado en todas las sucursales: ');
      readln(dni);
      montoTotal := incisoC (a,dni);
      writeln('El monto total gastado en todas las sucursales del cliente con DNI: ', dni, ' es: ', montoTotal:0:2);        
end.
       


