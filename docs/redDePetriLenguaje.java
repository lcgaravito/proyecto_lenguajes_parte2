p_red nombreejemplo
	var x = 5
	var y = 6
	var p = 1
	var inf = 10000
		sitio: coladeespera
			capacidad:= inf
			marcacion_i:= 0
		sitio: procesadores
			capacidad:= p+p
			marcacion_i:= capacidad
		sitio: trabajando1
			capacidad:= 1
			marcacion_i:= 0
		sitio: trabajando2
			capacidad:= 2
			marcacion_i:= 0
		sitio: sitiodeconteo
			capacidad:= inf
			marcacion_i:= 0

		transicion ( entrar, exponencial, x/3, ( x+4 )/3 )
		transicion atender1
		transicion atender2
		transicion ( terminar1, deterinistico, y+(-y/2) )
		transicion ( terminar2, uniforme, 1, 3 )
		
		arco ( entrando, entrar, coladeespera )
		arco ( coladeespera, atender1, 1)
		arco ( procesadores, atender1 )
		arco ( coladeespera, atender2, 1)
		arco ( procesadores, atender2, 2)
		arco ( atender2, trabajando2, 1)
		arco ( atender1, trabajando1, 1)
		arco ( trabajando2, terminar2, 1)
		arco ( trabajando1, terminar1, 1)
		arco ( terminar1, procesadores, 1)
		arco ( terminar2, procesadores, 1)
		arco ( terminar1, conteo, 1)
		arco ( terminar2, conteo, 2*p)
fin_red
----------------------------------------------------------

p_red nombreejemplo
var x = 5
var y = 6
var p = 1
var inf = 10000
sitio: coladeespera
capacidad:= inf
marcacion_i:= 0
sitio: procesadores
capacidad:= p+p
marcacion_i:= capacidad
sitio: trabajando1
capacidad:= 1
marcacion_i:= 0
sitio: trabajando2
capacidad:= 2
marcacion_i:= 0
sitio: sitiodeconteo
capacidad:= inf
marcacion_i:= 0
transicion ( entrar, exponencial, x/3, ( x+4 ) /3 )
transicion atender1
transicion atender2
transicion ( terminar1, deterministico, y+(-y/2) )
transicion ( terminar2, uniforme, 1, 3 )
arco ( entrando, entrar, coladeespera )
arco ( coladeespera, atender1, 1 )
arco ( procesadores, atender1 )
arco ( coladeespera, atender2, 1 )
arco ( procesadores, atender2, 2 )
arco ( atender2, trabajando2, 1 )
arco ( atender1, trabajando1, 1 )
arco ( trabajando2, terminar2, 1 )
arco ( trabajando1, terminar1, 1 )
arco ( terminar1, procesadores, 1 )
arco ( terminar2, procesadores, 1 )
arco ( terminar1, conteo, 1 )
arco ( terminar2, conteo, 2*p )
fin_red 