;spring particle

Graphics 640,480,32,2
SetBuffer BackBuffer()


;initial setting

Type Settings
	Field gravity#
	Field timestep#
End Type

Type particle
	Field mass#
	Field positionY#
	Field positionX#
	Field velocityY#
	Field velocityX#
End Type

Type anchor
	Field x#
	Field Y#
End Type

;stiffness = 2
;damping# = 10

;gravity# = 10
;timestep# = 0.28
Global set.settings = New settings
initSettings(5,0.28)

Obj.anchor = New anchor
Obj = setAnchor(Obj, 209,53)

p1.particle = New particle
p2.particle = New particle

p1 = SetSpring(p1, 30, 238, 89, 0,0)
p2 = SetSpring(p2, 30, 106, 85, 0,0)



;draw function
;--------------------------------------------------------------------------------------
While Not KeyHit(1)

	Cls
	DrawAnchor(Obj)
	SpringSimulation(p1, Obj\x,Obj\y, 2,2)
	SpringSimulation(p2, p1\positionX,p1\positionY, 2,2)
	Flip

Wend
;--------------------------------------------------------------------------------------
Function SpringSimulation(spring.particle,anchorX,anchorY,stiffness,damping)
	springforceY = -stiffness * (spring\PositionY - AnchorY)
	springforceX = -stiffness * (spring\PositionX - AnchorX)

	dampingforceY# = damping * spring\velocityY
	dampingforceX# = damping * spring\velocityX

	forceY# = springforceY + spring\mass * set\gravity - dampingforceY
	forceX# = springforceX - dampingforceX

	accelerationY# = forceY / spring\mass
	accelerationX# = forceX / spring\mass

	spring\velocityY = spring\velocityY + accelerationY * set\timestep
	spring\velocityX = spring\velocityX + accelerationX * set\timestep

	spring\positionY = spring\positionY + spring\velocityY * set\timestep
	spring\positionX = spring\positionX + spring\velocityX * set\timestep

	;Rect anchorX-5, anchorY-5, 10,10
	Line spring\positionX, spring\positionY, anchorX,anchorY
	Oval spring\positionX-10, spring\positionY-10, 20,20
	
	;Return spring
End Function

Function SetSpring.particle(spring.particle, m, x,y, vx,vy)
	spring\mass			= m
	spring\positionY	= y
	spring\positionX	= x
	spring\velocityY	= vy
	spring\velocityX	= vx
	Return spring
End Function

Function DrawAnchor(O.anchor)
		Rect O\x-5, O\y-5, 10,10
End Function

Function SetAnchor.anchor(O.anchor,x,y)
	O\x = x
	O\y = y
	Return O
End Function

Function initSettings(gravity,timestep#)
	set\gravity = gravity
	set\timestep = timestep
	;Return O
End Function
