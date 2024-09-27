{
 a) Implemente un módulo CargarListaOrdenada que cree una lista de
enteros y le agregue valores aleatorios entre el 100 y 150, hasta que se
genere el 120. Los valores dentro de la lista deben quedar ordenados
de menor a mayor. 
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



procedure insertar_Ordenado (var l:lista; aleatorio:integer);
var aux:lista; act,ant:lista;
begin
    new(aux);
    aux^.dato:= aleatorio;
    act:=l;
    ant:=l;
    while (act<> nil) and (act^.dato < aleatorio) do 
       begin
         ant:=act;
         act:=act^.sig;
      end;
   if (ant=act) then
       l := aux
   else begin
    ant^.sig:=aux;
   aux^.sig:= act;
   end;
end;

procedure  cargar_L (var l:lista); 
var aleatorio:integer;
begin
  randomize;
  randome(aleatorio);
  while (aleatorio <> corte) do 
  begin
    insertar_Ordenado(l,aleatorio);
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
  imprimir_L(l);
    writeln ('ingrese numero a encontrar');
  readln (num);
  writeln (buscar(l,num));
end.
