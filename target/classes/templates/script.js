function submitForm() {
    //this function stores all the values for each side
    var front1 = document.getElementById("front1");
    var front2 = document.getElementById("front2");
    var front3 = document.getElementById("front3");
    var front4 = document.getElementById("front4");

    var right1 = document.getElementById("right1");
    var right2 = document.getElementById("right2");
    var right3 = document.getElementById("right3");
    var right4 = document.getElementById("right4");

    var back1 = document.getElementById("back1");
    var back2 = document.getElementById("back2");
    var back3 = document.getElementById("back3");
    var back4 = document.getElementById("back4");

    var left1 = document.getElementById("left1");
    var left2 = document.getElementById("left2");
    var left3 = document.getElementById("left3");
    var left4 = document.getElementById("left4");

    var top1 = document.getElementById("top1");
    var top2 = document.getElementById("top2");
    var top3 = document.getElementById("top3");
    var top4 = document.getElementById("top4");

    var bottom1 = document.getElementById("bottom1");
    var bottom2 = document.getElementById("bottom2");
    var bottom3 = document.getElementById("bottom3");
    var bottom4 = document.getElementById("bottom4");

    
    
    var selectedValue1 = front1.value;
    var selectedValue2 = front2.value;
    var selectedValue3 = front3.value;
    var selectedValue4 = front4.value;

    var selectedValue5 = right1.value;
    var selectedValue6 = right2.value;
    var selectedValue7 = right3.value;
    var selectedValue8 = right4.value;

    var selectedValue9 = back1.value;
    var selectedValue10 = back2.value;
    var selectedValue11 = back3.value;
    var selectedValue12 = back4.value;

    var selectedValue13 = left1.value;
    var selectedValue14 = left2.value;
    var selectedValue15 = left3.value;
    var selectedValue16 = left4.value;

    var selectedValue17 = top1.value;
    var selectedValue18 = top2.value;
    var selectedValue19 = top3.value;
    var selectedValue20 = top4.value;

    var selectedValue21 = bottom1.value;
    var selectedValue22 = bottom2.value;
    var selectedValue23 = bottom3.value;
    var selectedValue24 = bottom4.value;


    //create array of colours
    var dataArray = [selectedValue1, selectedValue2, selectedValue3, selectedValue4, selectedValue5,
        selectedValue6, selectedValue7, selectedValue8, selectedValue9, selectedValue10, selectedValue11,
        selectedValue12, selectedValue13, selectedValue14, selectedValue15, selectedValue16, selectedValue17, 
        selectedValue18, selectedValue19, selectedValue20, selectedValue21, selectedValue22, selectedValue23, selectedValue24];
  
        
    var resultString = "";
    var numberArray = new Array(24);



    // for(var i = 0; i<dataArray.length; i++){
    //     if(dataArray[i] === "white"){
    //         numberArray[i] = 0;
    //     }else if(dataArray[i] === "red"){
    //         numberArray[i] = 1;
    //     }else if(dataArray[i] === "orange"){
    //         numberArray[i] = 2;
    //     }else if(dataArray[i] === "yellow"){
    //         numberArray[i] = 3;
    //     }else if(dataArray[i] === "green"){
    //         numberArray[i] = 4;
    //     }else if(dataArray[i] === "blue"){
    //         numberArray[i] = 5;
    //     }
    // }

    for (var i = 0; i < dataArray.length; i++) {
        resultString += dataArray[i][0];
    }

    //this is now ready to send over the backend
    console.log(resultString);
    

    //var arrayData = [1, 2, 3, 4, 5];
}
    