(define varfunc (lambda (. args)
		  (/
		    (apply + args)
		    (length args)
		    )
		  )
  )
(display (varfunc 5 6 7 8 9 5 3))
(newline)
