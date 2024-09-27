

{
a) Implemente un módulo CargarLista que cree una lista de enteros y le
agregue valores aleatorios entre el 100 y 150, hasta que se genere el
120.  
}


program programalista;


const 
  corte=120; max=150; min=100;
  
  
type
  rango= min..max;
  lista=^nodo;
  nodo=record  
    dato:integer;
    sig:lista;
  end;



procedure  crear_L (var l:lista);
begin
  l:=nil;
end;


procedure randome (var aleatorio:integer);
begin
   aleatorio:= random(max-min)+min;
end;



procedure agregar_Adelante (var l:lista; aleatorio:integer);
var aux:lista;
begin
  new(aux);
  aux^.dato:= aleatorio;
  aux^.sig:=l;
  l:=aux;
end;


procedure  cargar_L (var l:lista); 
var aleatorio:integer;
begin
  randomize;
  randome(aleatorio);
  aleatorio:= random(max-min)+min;
  while (aleatorio <> corte) do 
  begin
    agregar_Adelante (l,aleatorio);
    randome(aleatorio);
  end;
end;  

procedure imprimir_L (l:lista);
begin
  while (l<> nil) do 
  begin
    writeln(l^.dato);
    l:=l^.sig;
  end;
end; 
  
  
function buscar (l:lista; num:integer):boolean;  
var  encontre:boolean;                                                      // retorne true si el valor se encuentra en la lista y false en caso contrario.
begin 
  encontre:=false;
  while (l<>nil) and (not encontre ) do
        if (l^.dato = num) then 
            encontre:=true
        else
           l:=l^.sig;
  buscar:=encontre;
end;


var l:lista; num:integer;    
begin
  crear_L (l);
  cargar_L(l);
  //imprimir_L(l);
    writeln ('ingrese numero a encontrar');
  readln (num);
  writeln (buscar(l,num));
end.


