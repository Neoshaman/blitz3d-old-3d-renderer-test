Graphics 640,480,32,2
SetBuffer BackBuffer()
Origin 320,240; pinhole - lense


rayOriginX = 40;object distance
rayOriginY = 60

focalLength = -40;where the lens converge
imagePlaneDistance = -44
ApertureSize = 20
;FocusDistance = 0; where the object converge
;ObjectDistance = rayOriginX 
;ParallelrayY = ray origin Y (lensis at origin, x = 0)
;ImagePointX = 0
;ImagePointY = 0
;Lens = 0

;drawing way
DrawRayProjection(rayOriginX,rayOriginY, imagePlaneDistance, focalLength, ApertureSize)


WaitKey()

Function DrawRayProjection(rx#,ry#, i#, fl#,a#)
	gx = GraphicsWidth ()
	gy = GraphicsHeight()

	slope# = ry / rx
	ix# = i
	iy# = i * slope
	
	FocusDistance#  = ( (1 / (fl)) - (1 / rx) )^-1;( (1 / fl) - (1 / rx) )^-1 -> fl is already negative

	fx# = FocusDistance
	fy# = FocusDistance * slope;fy = - ry / ( (rx/-fl) -1)

	cr# = a * ( (i - fx) / fx);confusion radius fl should be FocusDistance ???


	;draw image plane
	Color 255,255,000
	Line i,gy, i,-gy

	;draw pinhole
	Color 255,000,000
	Line 0,gy, 0,-gy
	;Rect -5,-5, 10,10

	;drawRay
	Color 255,255,255
	Line rx,ry, fx,fy;medial
	Line rx,ry, ix,iy;pinhole
	;Rect ix-5,iy-5, 10,10;impact
	;Oval rx-5,ry-5, 10,10;origin


	Line rx,ry,	0,ry;parallel part 1
	Line 0,ry, fx,fy;parallel part 2
	;Oval fx-5,fy-5, 10,10;focusObject
	;focusplane
	Color 000,000,255
	Line fx,gy, fx,-gy

	;confusion and aperture
	Color 000,255,000
	Line rx,ry, 0,a
	Line 0,a, i,iy - cr


	;
	Color 255,255,255
	Text -gx/2,-gy/2+000, "rayOriginX  : " + rx
	Text -gx/2,-gy/2+020, "rayOriginY  : " + ry
	Text -gx/2,-gy/2+040, "ImagePointX : " + ix
	Text -gx/2,-gy/2+060, "ImagePointY : " + iy
	Text -gx/2,-gy/2+080, "focusPointx : " + fx
	Text -gx/2,-gy/2+100, "focusPointY : " + fy
	Text -gx/2,-gy/2+120, "focus size ratio : " + fy/ry
	Text -gx/2,-gy/2+140, "Confusion Radius : " + cr

End Function


;slope of ray = rayOriginY / RayOriginX
;equation of ray: y = (x * slope) + intercept (ie: y at x=0)
;imagePointY = imagePointX * slope (+ intercept but the pinhole is at origin)
;ImagepointX = ImagePlaneDistance
;imagePointY = ImagePlaneDistance * slope 
;------------------------------------------------------------------------------------
;thin lens approximation
;1. any ray that pass through the center of the lens doesn't get bend, they are the medial rays
;2. ray that refract when they pass the lens are called parallel rays,
;   they pass through the focal point at f distance on the x axis
;   where the two rays intersect define the distance at which the object comes into focus
;   all rays leaving the same point of an object will come into focus at the same place
;	all points parallel to the lens at the same distance come to focus on the same plane
;   this plane is call the focus plane
;by finding the intersection of these two type of rays,
;we find where all the ray of an Object will come into focus

;equation paralel line: y = (RayOriginY / focalLength) * x + RayOriginY
;intersection on focal point: when equation parallel equal equation median
; then divide by RayOriginY, then divide by x
; 1 / RayOriginX = 1 / focalLength + 1 / x
; that is 1 / ObjectDistance = 1 / focalLength + 1 / FocusDistance 
; that is 1 / ObjectDistance + 1 / FocusDistance = 1 / focalLength
; that is FocusDistance  = ( 1 / focalLength - 1 / ObjectDistance )^-1
;this is the simple lens law

;equation for circle of confusion
; radius confusion = radiusAperture * (imageplaneDistance - FocusDistance )/FocusDistance )


;->>focus distance = focal length
;circle of confusion express in term of focal length and objectDistance:
;confusion = aperture * focusDistance * (objectDistance - PerfectFocusDistance) ...
;.../ objectDistance (PerfectFocusDistance - focusDistance)
;perfectFocusDistance is WAY bigger than focusDistance, equation can be approximated as:
;.../objectDistance * perfectFocusDistance
;->>


