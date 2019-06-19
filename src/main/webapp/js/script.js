//раскрытие/соркытие блока
    function toggleinformer(){
      var elm = document.getElementById("informer");
      if(elm){
        if (elm.style.display == "block")
        {
          elm.style.display = "none";
        }
        else{
          elm.style.display = "block";
        }
      }
    }

//раскрытие/соркытие блока
       function toggleinformer2(){
      var elm = document.getElementById("informer2");
      if(elm){
        if (elm.style.display == "block")
        {
          elm.style.display = "none";
        }
        else{
          elm.style.display = "block";
        }
      }
    }

//раскрытие/соркытие блока
       function toggleinformer3(){
      var elm = document.getElementById("informer3");
      if(elm){
        if (elm.style.display == "block")
        {
          elm.style.display = "none";
        }
        else{
          elm.style.display = "block";
        }
      }
    }

//заполнение параметров (характеристик) этапов
    function fun1(){
      var param1 = document.getElementById("param11");
      var param2 = document.getElementById("param21");
      var param3 = document.getElementById("param31");
      var param4 = document.getElementById("param41");
      var param5 = document.getElementById("param51");
      var param6 = document.getElementById("param61");

      var sel = document.getElementById("selectName1").selectedIndex;
      var options = document.getElementById("selectName1").options;

      switch(options[sel].text){
        case 'Спуск по перилам':
        case 'Спуск по склону':
        case 'Подъем по перилам':
        case 'Подъем по склону':
        case 'Траверс склона':
              param1.style.display = "block";
              param2.style.display = "block";
              param3.style.display = "none";
              param4.style.display = "none";
              param5.style.display = "none";
              param6.style.display = "none";
              break;
              
        case 'Переправа в брод':
              param1.style.display = "block";
              param2.style.display = "none";
              param3.style.display = "block";
              param4.style.display = "none";
              param5.style.display = "none";
              param6.style.display = "none";
              break;

        case 'Переправа по бревну':
        case 'Переправа по бревну методом горизонтальный маятник':
              param1.style.display = "block";
              param2.style.display = "none";
              param3.style.display = "none";
              param4.style.display = "block";
              param5.style.display = "none";
              param6.style.display = "none";
              break;

        case 'Навесная переправа':
        case 'Переправа по параллельным перилам':
        case 'Спуск по наклонной навесной переправе':
        case 'Подъём по наклонной навесной переправе':
              param1.style.display = "block";
              param2.style.display = "none";
              param3.style.display = "none";
              param4.style.display = "none";
              param5.style.display = "block";
              param6.style.display = "none";
              break;

        case 'Переправа методом вертикальный маятник':
              param1.style.display = "block";
              param2.style.display = "none";
              param3.style.display = "none";
              param4.style.display = "none";
              param5.style.display = "none";
              param6.style.display = "block";
              break;
        default:;
      }
    }

//заполнение параметров (характеристик) этапов
    function fun2(){
      var param1 = document.getElementById("param12");
      var param2 = document.getElementById("param22");
      var param3 = document.getElementById("param32");
      var param4 = document.getElementById("param42");
      var param5 = document.getElementById("param52");
      var param6 = document.getElementById("param62");

      var sel = document.getElementById("selectName2").selectedIndex;
      var options = document.getElementById("selectName2").options;

      switch(options[sel].text){
        case 'Спуск по перилам':
        case 'Спуск по склону':
        case 'Подъем по перилам':
        case 'Подъем по склону':
        case 'Траверс склона':
              param1.style.display = "block";
              param2.style.display = "block";
              param3.style.display = "none";
              param4.style.display = "none";
              param5.style.display = "none";
              param6.style.display = "none";
              break;
        case 'Переправа в брод':
              param1.style.display = "block";
              param2.style.display = "none";
              param3.style.display = "block";
              param4.style.display = "none";
              param5.style.display = "none";
              param6.style.display = "none";
              break;

        case 'Переправа по бревну':
        case 'Переправа по бревну методом горизонтальный маятник':
              param1.style.display = "block";
              param2.style.display = "none";
              param3.style.display = "none";
              param4.style.display = "block";
              param5.style.display = "none";
              param6.style.display = "none";
              break;

        case 'Навесная переправа':
        case 'Переправа по параллельным перилам':
        case 'Спуск по наклонной навесной переправе':
        case 'Подъём по наклонной навесной переправе':
              param1.style.display = "block";
              param2.style.display = "none";
              param3.style.display = "none";
              param4.style.display = "none";
              param5.style.display = "block";
              param6.style.display = "none";
              break;

        case 'Переправа методом вертикальный маятник':
              param1.style.display = "block";
              param2.style.display = "none";
              param3.style.display = "none";
              param4.style.display = "none";
              param5.style.display = "none";
              param6.style.display = "block";
              break;
        default:;
      }
    }

    //заполнение параметров (характеристик) этапов
    function fun3(){
      var param1 = document.getElementById("param13");
      var param2 = document.getElementById("param23");
      var param3 = document.getElementById("param33");
      var param4 = document.getElementById("param43");
      var param5 = document.getElementById("param53");
      var param6 = document.getElementById("param63");

      var sel = document.getElementById("selectName3").selectedIndex;
      var options = document.getElementById("selectName3").options;

      switch(options[sel].text){
        case 'Спуск по перилам':
        case 'Спуск по склону':
        case 'Подъем по перилам':
        case 'Подъем по склону':
        case 'Траверс склона':
              param1.style.display = "block";
              param2.style.display = "block";
              param3.style.display = "none";
              param4.style.display = "none";
              param5.style.display = "none";
              param6.style.display = "none";
              break;
        case 'Переправа в брод':
              param1.style.display = "block";
              param2.style.display = "none";
              param3.style.display = "block";
              param4.style.display = "none";
              param5.style.display = "none";
              param6.style.display = "none";
              break;

        case 'Переправа по бревну':
        case 'Переправа по бревну методом горизонтальный маятник':
              param1.style.display = "block";
              param2.style.display = "none";
              param3.style.display = "none";
              param4.style.display = "block";
              param5.style.display = "none";
              param6.style.display = "none";
              break;

        case 'Навесная переправа':
        case 'Переправа по параллельным перилам':
        case 'Спуск по наклонной навесной переправе':
        case 'Подъём по наклонной навесной переправе':
              param1.style.display = "block";
              param2.style.display = "none";
              param3.style.display = "none";
              param4.style.display = "none";
              param5.style.display = "block";
              param6.style.display = "none";
              break;

        case 'Переправа методом вертикальный маятник':
              param1.style.display = "block";
              param2.style.display = "none";
              param3.style.display = "none";
              param4.style.display = "none";
              param5.style.display = "none";
              param6.style.display = "block";
              break;
        default:;
      }
    }

    //заполнение параметров (характеристик) этапов
    function fun4(){
      var param1 = document.getElementById("param14");
      var param2 = document.getElementById("param24");
      var param3 = document.getElementById("param34");
      var param4 = document.getElementById("param44");
      var param5 = document.getElementById("param54");
      var param6 = document.getElementById("param64");

      var sel = document.getElementById("selectName4").selectedIndex;
      var options = document.getElementById("selectName4").options;

      switch(options[sel].text){
        case 'Спуск по перилам':
        case 'Спуск по склону':
        case 'Подъем по перилам':
        case 'Подъем по склону':
        case 'Траверс склона':
              param1.style.display = "block";
              param2.style.display = "block";
              param3.style.display = "none";
              param4.style.display = "none";
              param5.style.display = "none";
              param6.style.display = "none";
              break;
        case 'Переправа в брод':
              param1.style.display = "block";
              param2.style.display = "none";
              param3.style.display = "block";
              param4.style.display = "none";
              param5.style.display = "none";
              param6.style.display = "none";
              break;

        case 'Переправа по бревну':
        case 'Переправа по бревну методом горизонтальный маятник':
              param1.style.display = "block";
              param2.style.display = "none";
              param3.style.display = "none";
              param4.style.display = "block";
              param5.style.display = "none";
              param6.style.display = "none";
              break;

        case 'Навесная переправа':
        case 'Переправа по параллельным перилам':
        case 'Спуск по наклонной навесной переправе':
        case 'Подъём по наклонной навесной переправе':
              param1.style.display = "block";
              param2.style.display = "none";
              param3.style.display = "none";
              param4.style.display = "none";
              param5.style.display = "block";
              param6.style.display = "none";
              break;

        case 'Переправа методом вертикальный маятник':
              param1.style.display = "block";
              param2.style.display = "none";
              param3.style.display = "none";
              param4.style.display = "none";
              param5.style.display = "none";
              param6.style.display = "block";
              break;
        default:;
      }
    }

    //заполнение параметров (характеристик) этапов
    function fun5(){
      var param1 = document.getElementById("param15");
      var param2 = document.getElementById("param25");
      var param3 = document.getElementById("param35");
      var param4 = document.getElementById("param45");
      var param5 = document.getElementById("param55");
      var param6 = document.getElementById("param65");

      var sel = document.getElementById("selectName5").selectedIndex;
      var options = document.getElementById("selectName5").options;

      switch(options[sel].text){
        case 'Спуск по перилам':
        case 'Спуск по склону':
        case 'Подъем по перилам':
        case 'Подъем по склону':
        case 'Траверс склона':
              param1.style.display = "block";
              param2.style.display = "block";
              param3.style.display = "none";
              param4.style.display = "none";
              param5.style.display = "none";
              param6.style.display = "none";
              break;
        case 'Переправа в брод':
              param1.style.display = "block";
              param2.style.display = "none";
              param3.style.display = "block";
              param4.style.display = "none";
              param5.style.display = "none";
              param6.style.display = "none";
              break;

        case 'Переправа по бревну':
        case 'Переправа по бревну методом горизонтальный маятник':
              param1.style.display = "block";
              param2.style.display = "none";
              param3.style.display = "none";
              param4.style.display = "block";
              param5.style.display = "none";
              param6.style.display = "none";
              break;

        case 'Навесная переправа':
        case 'Переправа по параллельным перилам':
        case 'Спуск по наклонной навесной переправе':
        case 'Подъём по наклонной навесной переправе':
              param1.style.display = "block";
              param2.style.display = "none";
              param3.style.display = "none";
              param4.style.display = "none";
              param5.style.display = "block";
              param6.style.display = "none";
              break;

        case 'Переправа методом вертикальный маятник':
              param1.style.display = "block";
              param2.style.display = "none";
              param3.style.display = "none";
              param4.style.display = "none";
              param5.style.display = "none";
              param6.style.display = "block";
              break;
        default:;
      }
    }

        //заполнение параметров (характеристик) этапов
    function fun6(){
      var param1 = document.getElementById("param16");
      var param2 = document.getElementById("param26");
      var param3 = document.getElementById("param36");
      var param4 = document.getElementById("param46");
      var param5 = document.getElementById("param56");
      var param6 = document.getElementById("param66");

      var sel = document.getElementById("selectName6").selectedIndex;
      var options = document.getElementById("selectName6").options;

      switch(options[sel].text){
        case 'Спуск по перилам':
        case 'Спуск по склону':
        case 'Подъем по перилам':
        case 'Подъем по склону':
        case 'Траверс склона':
              param1.style.display = "block";
              param2.style.display = "block";
              param3.style.display = "none";
              param4.style.display = "none";
              param5.style.display = "none";
              param6.style.display = "none";
              break;
        case 'Переправа в брод':
              param1.style.display = "block";
              param2.style.display = "none";
              param3.style.display = "block";
              param4.style.display = "none";
              param5.style.display = "none";
              param6.style.display = "none";
              break;

        case 'Переправа по бревну':
        case 'Переправа по бревну методом горизонтальный маятник':
              param1.style.display = "block";
              param2.style.display = "none";
              param3.style.display = "none";
              param4.style.display = "block";
              param5.style.display = "none";
              param6.style.display = "none";
              break;

        case 'Навесная переправа':
        case 'Переправа по параллельным перилам':
        case 'Спуск по наклонной навесной переправе':
        case 'Подъём по наклонной навесной переправе':
              param1.style.display = "block";
              param2.style.display = "none";
              param3.style.display = "none";
              param4.style.display = "none";
              param5.style.display = "block";
              param6.style.display = "none";
              break;

        case 'Переправа методом вертикальный маятник':
              param1.style.display = "block";
              param2.style.display = "none";
              param3.style.display = "none";
              param4.style.display = "none";
              param5.style.display = "none";
              param6.style.display = "block";
              break;
        default:;
      }
    }