# SI_2023_lab2_213233
## Lazar Panov 213233

### Control Flow Graph
![finalv2](https://github.com/lazarpanov/SI_2023_lab2_213233/blob/master/finalv2.png?raw=true)


### Циккломатска комплексност
- Цикломатската комплексност изнесува 11, ја добив преку број на региони (10) + 1

### Every Branch
        //TEST 1
        RuntimeException ex;
        ArrayList<User> nullUsers = new ArrayList<>();
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(new User(null, null, null), nullUsers));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        //TEST 2
        User case2 = new User(null, "testhjkt&", "case2@gmail.com");
        List<User> listForCase2 = new ArrayList<>();
        listForCase2.add(new User(null, null, null));
        listForCase2.add(new User("case2@gmail.com", "testhjkt", "case2@gmail.com"));
        assertFalse(SILab2.function(case2, listForCase2));

        //TEST 3
        User case3 = new User("case3", "case3", "testtest");
        assertFalse(SILab2.function(case3, listForCase2));

        //TEST 4
        User case4 = new User("sadasd", "hhhhhhhhh ", "case4@gmail.com");
        assertFalse(SILab2.function(case4, listForCase2));

        //TEST 5
        User case5 = new User("case5", "abcdefgh", "case5@test.com");
        assertFalse(SILab2.function(case5, nullUsers));
TEST 1
- пробувам да додадам null user во празна листа за да се провери exceptionot

TEST 2
- user-от има null username за да се провери if-от за превземање на username од email, потоа ќе влезе во првиот for, првиот loop нема да ги провери if-овите но вториот loop ќе влезе во if-овите и same ќе биде 2, потоа ќе се обиде да влезе во if-овит за проверва на password, па ќе отиде во else делот во if-овит за празно место, потоа ќе го проверува password-от за специјален карактер и ќе заврши на same == 0 (false)

TEST 3
- ќе врати false кога ќе влезе во if-от за проверка на password 

TEST 4
- ќе врати false кога ќе провери if (!passwordLower.contains(" ")) и ќе отиде на крај во return false

TEST 5
- ќе влезе во if условот за password со празно место, потоа ќе го изврти for циклусот без да најде match за специјален карактер и ќе врати false на 74-ти ред
### Multiple condition
        //CASE 1
        RuntimeException ex;
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(null, null));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        //CASE 2
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(new User("something", null, null), null));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        //CASE 3
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(new User("something", "test", null), null));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        //CASE 4
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(new User("something", "test", "testing@gmail.com"), null));
        assertFalse(ex.getMessage().contains("Mandatory information missing!"));

- T || X || X -> кога user е null
- F || T || X -> кога user не е null но password-ot е null
- F || F || T -> кога user не е null, password-от не е null но email-от е null 
- F || F || F -> кога user не е null, password-ot не null и email-от не null

