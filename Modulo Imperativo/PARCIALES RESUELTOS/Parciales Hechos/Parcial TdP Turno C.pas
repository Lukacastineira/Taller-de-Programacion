program Castineira;

type
     dias = 1..31;
     envio = record
         cliente:integer;         // FIN CLIENTE 0
         dia:dias;
         codPostal:integer;
         peso:real;
      end;
      
      envioL = record 
          cliente:integer;
          dia:dias;
          peso:real;
      end;
      
      lista = ^nodoLista;
      nodoLista = record 
         dato:envioL;
         sig:lista;
      end;
      
      envioA = record
           codPostal:integer;
           list:lista;
      end;
      
      arbol = ^nodoArbol;
      nodoArbol = record
           dato:envioA;
           HD:arbol;
           HI:arbol;
      end;
      
      procedure  leerEnvio  (var e:envio);
      begin
             e.cliente := Random (100);
             if (e.cliente <> 0 ) then
             begin
                   e.dia:= Random (31)+1;
                   e.codPostal:= Random (2000-1200)+1200;
                   e.peso:= Random(9000)+1 / (Random(4)+1);
             end;
      end;
      
      procedure agregarAdelante (var l:lista; e:envioL);
      var nue:lista;
      begin
              new (nue); nue^.dato:= e;  nue^.sig:=l; l:=nue;
      end;
      
      procedure agregarArbol  ( var a:arbol; e:envioL; codPostal:integer);
      begin
             if (a = nil) then
             begin
                    new (a); a^.dato.codPostal:= codPostal; a^.dato.list:=nil; 
                    agregarAdelante(a^.dato.list,e);
                    a^.HD:=nil; a^.HI:= nil;
             end
             else if (codPostal = a^.dato.codPostal) then agregarAdelante (a^.dato.list,e)
             else if (codPostal < a^.dato.codPostal) then agregarArbol (a^.HI,e,codPostal)
             else agregarArbol (a^.HD,e,codPostal);
      end;
      
      procedure pasarD  (var e:envioL;  cliente:integer; peso:real; dia:dias);
      begin
              e.cliente:=cliente;
              e.peso:=peso;
              e.dia:=dia;
      end;
      
      procedure cargarEstructura ( var a:arbol);
      var  e:envio; eL:envioL;
      begin
            leerEnvio(e);
            while (e.cliente <> 0) do
            begin
                  pasarD (eL,e.cliente,e.peso,e.dia);
                  agregarArbol (a,eL,e.codPostal);
                  leerEnvio (e);
            end;
      end;
      
      procedure listaNueva (l:lista; var lB:lista);
      var aux:lista;
      begin
            aux:=l;
            while (aux <> nil) do
            begin
                   agregarAdelante (lB,aux^.dato);
                   aux:= aux^.sig;
            end;
      end;
      
      procedure  incisoB (a:arbol; var lB:lista; postal:integer);
      begin
           if (a <> nil) then
           begin
                if (postal = a^.dato.codPostal) then   listaNueva (a^.dato.list, lB)
                else if ( postal < a^.dato.codPostal) then  incisoB (a^.HI,lB,postal)
                else  incisoB (a^.HD,lB,postal);
           end;
      end;
      
      procedure incisoC (l:lista; var min,max:real);
      begin
            if (l <> nil) then
            begin
                  if (min> l^.dato.peso) then
                        min:=l^.dato.peso;
                  if (max < l^.dato.peso) then
                       max:=l^.dato.peso;
                  incisoC(l^.sig,min,max);
            end;
      end;
     
      procedure imprimirL (l:lista);
      var aux:lista;
      begin
           aux:=l;
           while (aux <> nil) do
           begin
                 writeln ('Codigo Cliente: ', aux^.dato.cliente);
                 writeln ('Dia: ', aux^.dato.dia);
                 writeln ('Peso: ', aux^.dato.peso:0:2);
                 aux:= aux^.sig;
           end;
      end;
      
      procedure imprimirA (a:arbol);
      begin
           if ( a <> nil) then
           begin
                 imprimirA (a^.HI);
                 writeln ('|\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\|');
                 writeln ('Codigo Postal: ', a^.dato.codPostal);
                 writeln ('|\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\|');
                 imprimirL (a^.dato.list);
                 writeln ('|__________________________|');
                 imprimirA (a^.HD);
           end;
      end;
      
      var a:arbol;  postal:integer; lB:lista;  max,min:real;
      begin
            a:=nil; lB:=nil;
            min:=9999;
            max:=-1;
            cargarEstructura(a);
            imprimirA (a);
            readln (postal);
            incisoB (a,lB,postal);
            imprimirL (lB);
            incisoC (lB,min,max);
            writeln ('El minimo peso es: ',min:0:2);
            writeln ('El maximo peso es: ',max:0:2);
      end.
      
      
      
      
      
      
