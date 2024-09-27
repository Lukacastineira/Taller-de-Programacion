{
1. El administrador de un edificio de oficinas tiene la información del pago de las expensas
de dichas oficinas. Implementar un programa con:



a) Un módulo que retorne un vector, sin orden, con a lo sumo las 300 oficinas que
administra. Se deben cargar, para cada oficina, el código de identificación, DNI del
propietario y valor de la expensa. La lectura finaliza cuando llega el código de
identificación 0.



b) Un módulo que reciba el vector retornado en a) y retorne dicho vector ordenado por
código de identificación de la oficina. Ordenar el vector aplicando uno de los métodos
vistos en la cursada.



c) Un módulo que realice una búsqueda dicotómica. Este módulo debe recibir el vector
generado en b) y un código de identificación de oficina. En el caso de encontrarlo, debe
retornar la posición del vector donde se encuentra y en caso contrario debe retornar 0.
Luego el programa debe informar el DNI del propietario o un cartel indicando que no
se encontró la oficina.



d) Un módulo recursivo que retorne el monto total de las expensas.

   
}


PROGRAM   P5P1;
CONST
        dimF=300;
TYPE
       oficina = record
           codigo:integer;              // FIN CODIGO  0  !!!
           DNI:integer;
           expensa:real;
        end;
       Vexpensas= array [1..dimF] of  oficina;

Procedure LeerO (var o:oficina);
begin
      writeln('Ingrese codigo de identificacion: ');
      readln (o.codigo);
      if (o.codigo <> 0) then
      begin
           writeln('Ingrese DNI de Propietario: ');
           readln(o.DNI);
           writeln('Ingrese monto de Expensa: ');
           readln (o.expensa);
      end;
end;



procedure  cargarVE (var v:Vexpensas; var dimL:integer );
var   o:oficina;
begin
      LeerO(o);
      while  (o.codigo <> 0) and (dimL <= dimF) do                                                     //////    A--------------------------------------
      begin
             dimL:=dimL + 1;
              v[dimL]:= o;
              LeerO(o);
       end;
end;       

procedure  OrdenarV  (var v:Vexpensas; dimL:integer);
var   i,j:integer;  actual:oficina;
begin
       for i:= 2 to dimL do 
       begin
            actual:=v[i];
            j:= i -1;
            while (j>0) and (v[j].codigo > actual.codigo) do                                                                   ////////   B-------------------------------------
            begin  
                v[j+1]:= v[j];
                j:=j-1;
             end;
             v[j+1] := actual;
       end;                 
end;

function busquedadicotomica(v : Vexpensas; codigo : integer; dimL:integer; pri,fin:integer) : integer;
var
	medio:integer;
begin
	if(diml > 0) then
		begin
			if(pri <= fin) then
				begin
					medio:= (pri + fin) div 2;
					if(v[medio].codigo = codigo) then
						busquedadicotomica := medio                                                                                          ///// C---------------------------------------------------
					else if(codigo < v[medio].codigo) then
						busquedadicotomica := busquedadicotomica(v, codigo, diml, pri, medio-1)
					else
						busquedadicotomica := busquedadicotomica(v, codigo, diml, medio+1, fin);
				end
			else
				busquedadicotomica := 0;
		end
	else
		busquedadicotomica := 0;
end;

function   montoTE  (v:Vexpensas;  dimL:integer; i:integer): real;
begin
     if (i <= dimL) then
     begin
             montoTE :=  v[i].expensa + montoTE ( v , dimL, i + 1);                                        /////       D-----------------------------------------------
     end;       
end;

procedure ImprimirV (v:Vexpensas; dimL:integer);
var i:integer;
begin
     for i:= 1 to dimL do
     begin
          writeln ('El codigo de identificacion es: ', v[i].codigo);
          writeln ('El DNI es: ', v[i].DNI);
          writeln ('El valor de las expensas es: ', v[i].expensa:0:2);
     end;
end;
var    v:Vexpensas;  dimL:integer;   codigo:integer;  valor:integer; pri,fin:integer;  total:real; i:integer;

begin
      cargarVE(v,dimL);
      ImprimirV(v,dimL);
      OrdenarV (v,dimL);
      writeln  ('------------------------');
      ImprimirV(v,dimL);
      writeln ('Ingrese codigo a buscar: ');
      readln (codigo);
      pri:=1;
      fin:=dimL;
      valor:= busquedadicotomica (v,codigo,dimL,pri,fin);
      if (valor = 0) then  writeln ('El codigo no existe.')
      else writeln ('El codigo se encontro en la posicion: ', valor);
      i:=1;
      total:=montoTE(v,dimL,i); 
      writeln ('El monto total de expensas es: ', total:0:2);
end.




