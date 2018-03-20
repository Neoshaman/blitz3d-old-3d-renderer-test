;Basic3d

Graphics 640,480,32,2
SetBuffer BackBuffer()
;Origin GraphicsWidth()/2,GraphicsHeight()/2

Restore cube

camx# = 0
camy# = 10
camz# = 10

horizon# = GraphicsHeight()/2
vanishing# =  GraphicsWidth()/2
zoom# = 10
scale# = 100

For i=1 To 8
	Read x#
	Read y# 
	Read z#

	z = (z+camz) +zoom 
	x = scale * (x+camx) /z +vanishing 
	y = scale * (y+camy) /z +horizon 
	
	Plot x,y
Next

WaitKey()

.cube
Data 10,10,10
Data -10,10,10
Data -10,-10,10
Data 10,-10,10

Data 10,10,-10
Data -10,10,-10
Data -10,-10,-10
Data 10,-10,-10

