{

3. Implementar un programa que contenga:


a. Un módulo que lea información de los finales rendidos por los alumnos de la Facultad de
Informática y los almacene en una estructura de datos. La información que se lee es legajo,
código de materia, fecha y nota. La lectura de los alumnos finaliza con legajo 0. La estructura
generada debe ser eficiente para la búsqueda por número de legajo y para cada alumno deben
guardarse los finales que rindió en una lista.



b. Un módulo que reciba la estructura generada en a. y retorne la cantidad de alumnos con
legajo impar.



c. Un módulo que reciba la estructura generada en a. e informe, para cada alumno, su legajo y
su cantidad de finales aprobados (nota mayor o igual a 4).


d. Un módulo que reciba la estructura generada en a. y un valor real. Este módulo debe
retornar los legajos y promedios de los alumnos cuyo promedio supera el valor ingresado.


} 


program  P3P3; 
type 
        fecha = 1..31; 
	
        finalL = record 
	    codigo:integer;
	    fecha:integer;
	    nota:real;
         end;
	 
	lista = ^nodo;
	nodo = record
	   dato:finalL;
	   sig:lista;
        end;
	  
	arbolF = ^nodo1;
	nodo1 = record
	    legajo:integer;
	    list:lista;
            HD:arbolF;
	    HI:arbolF;
	end;
    
    promsupera =record 
        legajo:integer;
        promedio:real;
   end;
    
      listaD =^nodo2;
      nodo2=record
        dato:promsupera;
        sig:listaD;
      end;
	
procedure   leerFinal  ( var legajo:integer;   var   f:finalL);
begin
          writeln ( ' Ingrese el Legajo del alumno: ');
	  readln(legajo);
           if  (  legajo <>  0 )  then
	   begin
	        writeln ( ' Ingrese el codigo de materia: ');
		readln(f.codigo);
		writeln ( ' Ingrese la fecha del final: ');
		readln(f.fecha);
		writeln ( ' Ingrese la nota: ');
	        readln(f.nota);
	  end;
end;


procedure agregarA  (var l:lista;  f:finalL); 
var   nue:lista;
begin
      new(nue); nue^.dato:=f;  nue^.sig:=l;  l:= nue;
end;



procedure insertarAF  (var a:arbolF;  legajo:integer;  f:finalL);
begin
        if (a=nil) then
	      begin
	          new(a);  a^.legajo:= legajo;  a^.list:=nil;
		     agregarA (a^.list,f); 
		     a^.HD := nil;  a^.HI:= nil;
	      end
	    else if ( legajo = a^.legajo) then  agregarA (a^.list,f)
	    else if (legajo < a^.legajo)  then  insertarAF(a^.HI,legajo,f)
        else      insertarAF (a^.HD,legajo,f);
end;	       
	       
	       
procedure cargarAF (var a:arbolF);
var     legajo:integer;  f:finalL;
begin
      leerFinal (legajo,f);
      while (legajo <> 0) do                                                                                            //  A-------------------------------------------
      begin
           insertarAF(a,legajo,f);
           leerFinal (legajo,f);
     end;
end;

function   esPar  ( num:integer): boolean;
var  cumple: boolean;
begin
      cumple:= false;
      if (num mod 2 = 0) then
          cumple:= true;
      esPar:=cumple;
end;


procedure   incisoB (  a : arbolF;   var cont : integer  );
begin
      if (a<> nil) then
          begin
                 if (esPar (a^.legajo)) then 
                      cont:= cont + 1;                                                                                       //  B--------------------------------------------
                 incisoB (a^.HI,cont);
                 incisoB(a^.HD,cont);
          end;
end;


procedure   incisoCL (l:lista; var aprobados:integer) ; 
begin
     while ( l <> nil )   do 
     begin 
           if (l^.dato.nota >= 4) then
                 aprobados:= aprobados + 1;
           l:=l^.sig;
     end;
end;

procedure incisoC  (a:arbolF);
var   aprobados: integer; 
begin 
     aprobados:= 0;
     if (a<>nil) then
         begin
               incisoC (a^.HI);                                                                                              //  C---------------------------------------------
               writeln ('El alumno con legajo: ', a^.legajo) ;
               incisoCL (a^.list, aprobados);
               writeln (' tiene: ', aprobados , ' Finales aprobados.');
               incisoC (a^.HD);
          end;
end;

procedure agregarAD  (var l:listaD;  p:promsupera); 
var   nue:listaD;
begin
      new(nue); nue^.dato:=p;  nue^.sig:=l;  l:= nue;
end;
    
procedure   incisoDL  (l:lista; var promedio:real ) ; 
 var contador:integer;
 begin
    contador:= 0;
     while ( l <> nil )   do 
     begin 
          contador:= contador + 1;
          promedio:= promedio + l^.dato.nota; 
           l:=l^.sig;
     end;
     promedio:=promedio / contador; 
end;

procedure incisoD (a:arbolF; var LD:listaD; numD:real);
var  promedio:real;  p:promsupera;
begin
    if (a<> nil) then
    begin
          promedio:= 0;
          incisoD (a^.HI,LD,numD);
          incisoDL(a^.list, promedio); 
          if (promedio > numD) then
          begin                                                                                                                   //  D----------------------------------------------
                p.legajo:=  a^.legajo;
                p.promedio:= promedio;
                agregarAD( LD, p);
          end;
          incisoD (a^.HI,LD,numD);
     end;
end;

procedure  imprimirL (l:lista);
begin
          writeln('|------------------|');
          writeln('|-----LISTA-----|');
    while (l<>nil) do 
    begin
          writeln (' El codigo de materia del final es: ', l^.dato.codigo);
          writeln (' La fecha del final es: ', l^.dato.fecha);
          writeln (' La nota del final es: ', l^.dato.nota:0:2);
          l:=l^.sig;
    end;
          writeln('|___________|');
end;
	       

procedure imprimirAF (a:arbolF);
begin
     if (a<>nil) then
         begin
               imprimirAF(a^.HI);
               writeln ('El legajo de alumno es: ', a^.legajo);
               imprimirL(a^.list);
               imprimirAF (a^.HD);
         end;
end;	  

procedure imprimirLD (l:listaD);
begin
    while (l<>nil) do 
    begin
           writeln ('LEGAJO: ', l^.dato.legajo);
           writeln ('PROMEDIO: ', l^.dato.promedio:0:2);
           l:=l^.sig;
    end;
end;


var           a:arbolF;  cont:integer;  numD:real;  LD:listaD;

begin
     cont:= 0;
     cargarAF (a);
     imprimirAF (a);
     incisoB (a,cont);
     writeln ('La cantidad de alumnos con legajos pares es: ', cont);
     incisoC (a);
     writeln ('Ingrese numero a superar: ' );
     readln (numD);
     incisoD (a,LD,numD);
     writeln ('Los alumnos con promedio que superan el numero ingresado son: ');
     imprimirLD (LD);
end.
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	    
 
