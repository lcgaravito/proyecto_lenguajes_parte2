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

transicion ( entrar, exponencial, x/3, ( x+4 )/3 )
transicion atender1
transicion atender2
transicion ( terminar1, deterinistico, y+(-y/2) )
transicion ( terminar2, uniforme, 1, 3 )