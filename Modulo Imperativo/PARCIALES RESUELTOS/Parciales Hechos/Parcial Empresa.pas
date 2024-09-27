program castineira;

type 

   dias = 0..31;  meses= 1..12; rangoHoras=1..8;
   empleado  = record
       numero:integer;
      dia:dias;    //  fin registro dia 0
      mes:meses;
      horas:rangoHoras;
   end;
   
   empleadoL  = record
       dia:dias;
       mes:meses;
       horas:rangoHoras;
   end;
   
   lista  = ^nodoLista;
   nodoLista = record
       dato:empleadoL;
       sig:lista;
   end;
   
   arbol= ^nodoArbol;
   nodoArbol = record
       dato:empleado;
       HD:arbol;
       HI:arbol;
   end;
   
   
   procedure leerRegistro  (var e:empleado);
   begin
      e.dia:= Random (32); 
      if (e.dia  <> 0 ) then
      begin
          e.numero:= Random (101);
          e.mes:= Random(12)+1;
          e.horas:= Random (8)+1;
      end;
   end;
   
   procedure agregarAdelante  (var l:lista; eL:empleadoL);
   var nue: lista;
   begin
      new  (nue);  nue^.dato:= eL; nue^.sig:=l; l:=nue;
   end;
   
   procedure agregarArbol  (var a:arbol; e:empleado);
   begin 
       if (a= nil) then 
         begin
              new(a); a^.dato:= e;
              a^.HI:=nil; a^.HD:= nil;
         end
         else  if (e.numero < a^.dato.numero) then agregarArbol (a^.HI,e)
         else agregarArbol(a^.HD,e);
   end;
   
   procedure pasarP  (var eL:empleadoL; dia:dias; mes:meses; horas:rangoHoras);
   begin
       eL.dia:= dia;
       eL.mes:= mes;
       eL.horas:= horas;
   end;
   
   procedure  cargarEstructura  (var a:arbol);
   var   e:empleado; 
   begin
      leerRegistro(e);
      while  (e.dia <> 0) do
        begin
           agregarArbol(a,e);
           leerRegistro (e);
        end;
    end;
    
    procedure  incisoB  (a:arbol; var lB:lista; x,y:integer);
    var  eL:empleadoL;
    begin
       if (a <> nil )  then 
       begin
           if (x <= a^.dato.numero) and (y>= a^.dato.numero) then
           begin
               pasarP (eL, a^.dato.dia, a^.dato.mes, a^.dato.horas);
               agregarAdelante (lB, eL);
           end
           else if (x> a^.dato.numero) then incisoB (a^.HD,lB,x,y)            
           else  incisoB (a^.HI,lB,x,y);
       end;
    end;
    
    function  incisoC (l:lista) :integer;
    begin 
        if(l= nil) then incisoC:= 0
        else if (l <> nil) then
             incisoC:= l^.dato.horas + incisoC (l^.sig)
    end;


var a:arbol; x,y:integer; l:lista; cantHoras:integer;
begin
    a:= nil; l:=nil;
    randomize;
    cargarEstructura (a);
    readln (x);
    readln(y);
    incisoB (a,l,x,y);
    cantHoras:=incisoC (l);
    writeln (cantHoras);
end.