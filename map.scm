(define (mymap myfunc mylist)
  (if (null? mylist)
    '()
    (cons (myfunc (car mylist)) (mymap myfunc (cdr mylist)))
    )
  )
(display (mymap (lambda (x) (* x 2)) (list 1 2 3 4)))
(newline)
