; wavesurfing landscape

type Vcam
	field x
	field y
	field z
	
	field ry
	field rxz
	
	field Vtangente
	field Vroty
	field Vrotxz
	
	field fardistance
	field FOV
end type

;dx = cos(rxz) cos(ry) vtangente
;dz = cos(rxz) sin(ry) vtangente
;dy = sin(rxz) vtangente

;dry = vroty
;drxz = vrotxz

;wavesurfing
	;standard projection equation:
	;Ys =(yv - ye) * yk/z+yc
	;ys: ccordinate projected onto the screen
	;yv: altitude of teh voxel column
	;ye: coordinate of the eye
	;z: distance from the eye to the considered point
	;yk: constant to scale the projection, possibly negative
	;yc: constant to centre the projection, usually half teh screen resolution

	;for i from 0 to RESX do loop
	;     get the equation of the ray
	;     for j from MIN_DIST to MAX_DIST do loop
	;         find the point in the map
	;         get its altitude, and project it onto the screen
	;         if it's above the highest point drawn so far
	;            if the previous point was invisible clip the span
	;            draw a vertical span from the previous point to the current point
	;            set the highest point to be the current point
	;         end if
	;         exit the loop if the highest point is above the screen
	;     end loop
	; end loop
	
;Clipping is a pretty straightforward operation, 
;you have to test each angle of a quadrangle that delimits a zone 
;against three lines that I call left, right and near.
;	
;In order to clip, you have to determine the equation of each of those lines,
;finding the equation is equivalent to searching the normals to the lines in the 2D plane,
;the normals are defined in terms of FovHalfAngle and CamAngle,
;the two relevant angles of this configuration.
	;Nnear = cos(CamAngle).x + sin(CamAngle).y
	;Nleft = sin (CamAngle + FovHalfAngle).x - cos(CamAngle + FovHalfAngle).y
	;Nright = -sin(
	
	