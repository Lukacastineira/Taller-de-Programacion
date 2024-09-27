{
2.- El administrador de un edificio de oficinas cuenta, en papel, con la información del pago de
las expensas de dichas oficinas.
Implementar un programa que invoque a módulos para cada uno de los siguientes puntos:


a. Genere un vector, sin orden, con a lo sumo las 300 oficinas que administra. De cada oficina
se ingresa el código de identificación, DNI del propietario y valor de la expensa. La lectura
finaliza cuando se ingresa el código de identificación -1, el cual no se procesa.


b. Ordene el vector, aplicando el método de inserción, por código de identificación de la
oficina.


c. Ordene el vector aplicando el método de selección, por código de identificación de la oficina
}
PROGRAM P1P2;
CONST
  dimF=300;
TYPE
  rango_Oficinas=1..300; rangoDim= 1..300;
  oficina = RECORD
    codigo_I: INTEGER;
    DNI_P : INTEGER;
    expensas: REAL;
  END;
  oficinas = ARRAY [rango_Oficinas] OF oficina;

 
PROCEDURE  Leer_oficina  (VAR o:oficina);
BEGIN
  writeln (' Ingresar Codigo de Identificacion: ');
  readln (o.codigo_I);
  IF (o.codigo_I <> -1) THEN
  BEGIN
    writeln (' Ingresar DNI del Propietario: ');
    readln (o.DNI_P);
    writeln (' Ingresar valor expensas ');
    readln (o.expensas);
  END;
END;

PROCEDURE Cargar_Vector (VAR os:oficinas; VAR dimL:rangoDim);
VAR  o:oficina;
BEGIN
  Leer_oficina (o);
  dimL := 1;
  WHILE ( o.codigo_I <> -1) AND ( dimL <= dimF) DO                                             
  BEGIN
    os[dimL].codigo_I := o.codigo_I;
    os[dimL].DNI_P := o.DNI_P;
    os[dimL].expensas := o.expensas;
    Leer_oficina(o);
    dimL:= dimL + 1;
  END;
END;

PROCEDURE Ordenacion_I  (Var os:oficinas; dimL:rangoDim);
VAR  i,j:integer; actual:oficina;
BEGIN 
    FOR i:= 2 TO diml DO BEGIN
        actual := os[i];
        j:= i-1;
        WHILE (j>0) AND (os[j].codigo_I > actual.codigo_I) DO  
        BEGIN                                                           //b. Ordene el vector, aplicando el método de inserción, por código de identificación de la oficina.
          os[j+1] := os[j];
          j:= j-1;
        END;
        os[j+1]:= actual;
     END;
END;                                                                     
      
Procedure Ordenacion_S ( var os : oficinas ; dimL : rangoDim);
var
  i, j, p: integer;
  item : oficina;   //  item es del tipo del registro
begin
  for i:=1 to dimL-1 do begin   {  busca el mínimo os[p] entre os[i],...,v[n] }      //c. Ordene el vector aplicando el método de selección, por código de identificación de la oficina
    p := i;
    for j := i+1 to dimL do
      if (os[j].codigo_I < os[p].codigo_I) then   // se debe acceder al campo del registro por el cual se desea ordenar el vector
        p:=j;
    {intercambia os[i] y os[p] }
    item := os[p];
    os[p] := os[i];
    os[i] := item;
  end;
end;

VAR  os: oficinas; dimL:rangoDim; 

BEGIN
    
    Cargar_Vector (os,dimL);
    
    Ordenacion_I  (os,dimL);
    
    Ordenacion_S  (os, dimL);

END.                                                                
