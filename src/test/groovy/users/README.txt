For the sake of learning TDD, I'll be testing getters and setters too
---------------------------------------------------------------------


Unit tests are meant to test the behavior of something, so generally
it doesn't make sense to test simple getters and setters (unless they
have some complex logic).

If your getters and setters are simply getting and setting instance
variables without any additional logic, then testing them may not
provide much value.

In general, you should focus on testing the behavior of your class
rather than its internal implementation details. This means testing
the public methods of your class and ensuring they behave correctly
under different conditions and with different inputs. This way you
can test them indirectly by testing the behavior of the public methods
that use those variables, even though some may say that this is not
*unit* test.

There is a big debate about this. Check the thread bellow
* Should unit tests be written for getter and setters?
  https://stackoverflow.com/q/6197370/14113064

