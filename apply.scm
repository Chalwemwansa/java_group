(define (sum myargs)
  (if (null? myargs)
    0
    (+ (sum (cdr myargs)) (car myargs))
    )
  )
(display (sum (list 1 2 3 4 5 6 7)))
(newline)
