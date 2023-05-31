package com.greencomputing.quizforfun.other;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Patterns;

import androidx.annotation.RequiresApi;

import com.greencomputing.quizforfun.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

public class Utils {

    public static boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }

    public static String formatDate(long time){
        SimpleDateFormat formatter = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            formatter = new SimpleDateFormat(Constants.DATE_FORMAT, Locale.getDefault());
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        return formatter.format(calendar.getTime());
    }



    public static Map<String,Map<String,Boolean>> getEasyQuestions(){
        HashMap<String,Map<String,Boolean>> questions = new HashMap<>();

        HashMap<String,Boolean> answer1 = new HashMap<>();
        answer1.put("e-learning",false);
        answer1.put("e-shopping",false);
        answer1.put("e-waste",true);
        answer1.put("use of internet",false);
        questions.put("which is one of the fastest growing components of waste stream in the world.  ",answer1);

        HashMap<String,Boolean> answer2 = new HashMap<>();
        answer2.put("virtualization ",true);
        answer2.put("socialization",false);
        answer2.put("communication",false);
        answer2.put("transmission",false);
        questions.put(" _____ is achieved using specialized software which creates partitions of a server into smaller virtual servers to maximize server resources.",answer2);

        HashMap<String,Boolean> answer3 = new HashMap<>();
        answer3.put("oxygen footprint",false);
        answer3.put("carbon footprint",true);
        answer3.put("nitrogen footprint",false);
        answer3.put("toxin footprint",false);
        questions.put(" ______ is defined as the total amount of greenhouse gas emission caused by organization expressed as Co2.",answer3);

        HashMap<String,Boolean> answer4 = new HashMap<>();
        answer4.put("PCBs",false);
        answer4.put("cadmium",false);
        answer4.put("mercury",false);
        answer4.put("lead",true);
        questions.put("A typical computer monitor may contain more than 6 percent ___________ by weight.",answer4);

        HashMap<String,Boolean> answer5 = new HashMap<>();
        answer5.put("carbon footprint",true);
        answer5.put("Heat",false);
        answer5.put("",false);
        answer5.put("Pericles, Prince of Tyre",false);
        questions.put("One’s impact on the planet—there’s no standard definition is ____________",answer5);

        HashMap<String,Boolean> answer6 = new HashMap<>();
        answer6.put("NGOs",false);
        answer6.put("StEP",true);
        answer6.put("CRT",false);
        answer6.put("USA",false);
        questions.put("Optimizing the life cycle of electrical and electronic equipment by improving \n" +
                "supply chains is a prime objective of _________. ",answer6);

        HashMap<String,Boolean> answer7 = new HashMap<>();
        answer7.put("recycle",true);
        answer7.put("reuse",false);
        answer7.put("reduce",false);
        answer7.put("redesign",false);
        questions.put("The goal of the ___________ task force is to enhance global recycling infrastructures, \n" +
                "systems, and technologies while realizing sustainable e-waste-recycling systems",answer7);

        HashMap<String,Boolean> answer8 = new HashMap<>();
        answer8.put("data-de-duplication",true);
        answer8.put("virtualization",false);
        answer8.put("management",false);
        answer8.put("storage",false);
        questions.put("“_____________” is a tool for reducing storage and bandwidth consumed from diskbased backup.",answer8);

        HashMap<String,Boolean> answer9 = new HashMap<>();
        answer9.put("MAID",true);
        answer9.put("LAID",false);
        answer9.put("green drives",false);
        answer9.put("LCD",false);
        questions.put("____________ is designed for write once, read occasionally (WORO) applications. ",answer9);

        HashMap<String,Boolean> answer10 = new HashMap<>();
        answer10.put("cooling",true);
        answer10.put("pooling",false);
        answer10.put("monitor",false);
        answer10.put("LED",false);
        questions.put("___________ is a major component of your power consumption and, by extension, your IT budget. ",answer10);
        HashMap<String,Boolean> answer11 = new HashMap<>();
        answer11.put("supplier performance management",true);
        answer11.put("Analyze global issues",false);
        answer11.put("communicate supplier",false);
        answer11.put("supplier management",false);
        questions.put("When creating requests for proposals, make sure to include a green component as well as clear metrics for their measurement as part of ___________. ",answer11);

        HashMap<String,Boolean> answer12 = new HashMap<>();
        answer12.put("flexible_strip_curtains",true);
        answer12.put("rigid_enclosure",false);
        answer12.put("hot assel",false);
        answer12.put("Cool asile",false);
        questions.put("Use of ______________ to block the open air above your racks that have been configured into a hot-aisle/cool-aisle layout.",answer12);

        HashMap<String,Boolean> answer13 = new HashMap<>();
        answer13.put("paper",true);
        answer13.put("furniture",false);
        answer13.put("ink",false);
        answer13.put("all of  the above",false);
        questions.put("The biggest source of wood consumption is ___________ production.",answer13);

        HashMap<String,Boolean> answer14 = new HashMap<>();
        answer14.put("remote desktop",true);
        answer14.put("desktop server",false);
        answer14.put("desktop client",false);
        answer14.put("none of these",false);
        questions.put("If you buy thin clients, _____________ can be used to connect your thin clients to the server.",answer14);

        HashMap<String,Boolean> answer15 = new HashMap<>();
        answer15.put("CDs & DVDs",true);
        answer15.put("CDs",false);
        answer15.put("DVDs",false);
        answer15.put("None of the above",false);
        questions.put(" ____________ the components can be recycled into everything from automobile parts to office equipment.",answer15);

        return questions;
    }

    public static   Map<String,Map<String,Boolean>> getRandomMathQuestions(Context context, String subject, int SIZE){
        Map<String,Map<String,Boolean>> questionsMap = new HashMap<>();
        Map<String, Map<String, Boolean>> originalQuestion = getEasyQuestions();
        int originalSize =  originalQuestion.size();
        ArrayList<String> keyList = new ArrayList<String>(originalQuestion.keySet());

        while (questionsMap.size()<=SIZE){
            Random random = new Random();
            int randomNumber = random.nextInt(originalSize);
            String question = keyList.get(randomNumber);
            if (!questionsMap.containsKey(question)){
                questionsMap.put(question,originalQuestion.get(question));
            }
        }
        return questionsMap;
    }



    public static Map<String,Map<String,Boolean>> getModerateQuestions(){
        HashMap<String,Map<String,Boolean>> questions = new HashMap<>();

        HashMap<String,Boolean> answer1 = new HashMap<>();
        answer1.put("e-learning",false);
        answer1.put("e-shopping",false);
        answer1.put("e-waste",true);
        answer1.put("use of internet",false);
        questions.put("which is one of the fastest growing components of waste stream in the world.  ",answer1);

        HashMap<String,Boolean> answer2 = new HashMap<>();
        answer2.put("virtualization ",true);
        answer2.put("socialization",false);
        answer2.put("communication",false);
        answer2.put("transmission",false);
        questions.put(" _____ is achieved using specialized software which creates partitions of a server into smaller virtual servers to maximize server resources.",answer2);

        HashMap<String,Boolean> answer3 = new HashMap<>();
        answer3.put("oxygen footprint",false);
        answer3.put("carbon footprint",true);
        answer3.put("nitrogen footprint",false);
        answer3.put("toxin footprint",false);
        questions.put(" ______ is defined as the total amount of greenhouse gas emission caused by organization expressed as Co2.",answer3);

        HashMap<String,Boolean> answer4 = new HashMap<>();
        answer4.put("PCBs",false);
        answer4.put("cadmium",false);
        answer4.put("mercury",false);
        answer4.put("lead",true);
        questions.put("A typical computer monitor may contain more than 6 percent ___________ by weight.",answer4);

        HashMap<String,Boolean> answer5 = new HashMap<>();
        answer5.put("carbon footprint",true);
        answer5.put("Heat",false);
        answer5.put("",false);
        answer5.put("Pericles, Prince of Tyre",false);
        questions.put("One’s impact on the planet—there’s no standard definition is ____________",answer5);

        HashMap<String,Boolean> answer6 = new HashMap<>();
        answer6.put("NGOs",false);
        answer6.put("StEP",true);
        answer6.put("CRT",false);
        answer6.put("USA",false);
        questions.put("Optimizing the life cycle of electrical and electronic equipment by improving \n" +
                "supply chains is a prime objective of _________.",answer6);

        HashMap<String,Boolean> answer7 = new HashMap<>();
        answer7.put("recycle",true);
        answer7.put("reuse",false);
        answer7.put("reduce",false);
        answer7.put("redesign",false);
        questions.put("The goal of the ___________ task force is to enhance global recycling infrastructures, \n" +
                "systems, and technologies while realizing sustainable e-waste-recycling systems",answer7);

        HashMap<String,Boolean> answer8 = new HashMap<>();
        answer8.put("data-de-duplication",true);
        answer8.put("virtualization",false);
        answer8.put("management",false);
        answer8.put("storage",false);
        questions.put("“_____________” is a tool for reducing storage and bandwidth consumed from disk based backup.",answer8);

        HashMap<String,Boolean> answer9 = new HashMap<>();
        answer9.put("MAID",true);
        answer9.put("LAID",false);
        answer9.put("green drives",false);
        answer9.put("LCD",false);
        questions.put("____________ is designed for write once, read occasionally (WORO) applications. ",answer9);

        HashMap<String,Boolean> answer10 = new HashMap<>();
        answer10.put("cooling",true);
        answer10.put("pooling",false);
        answer10.put("monitor",false);
        answer10.put("LED",false);
        questions.put("___________ is a major component of your power consumption and, by extension, your IT budget. ",answer10);

        HashMap<String,Boolean> answer11 = new HashMap<>();
        answer11.put("supplier performance management",true);
        answer11.put("Analyze global issues",false);
        answer11.put("communicate supplier",false);
        answer11.put("supplier management",false);
        questions.put("When creating requests for proposals, make sure to include a green component as well as clear metrics for their measurement as part of ___________. ",answer11);

        HashMap<String,Boolean> answer12 = new HashMap<>();
        answer12.put("flexible_strip_curtains",true);
        answer12.put("rigid_enclosure",false);
        answer12.put("hot assel",false);
        answer12.put("Cool asile",false);
        questions.put("Use of ______________ to block the open air above your racks that have been configured into a hot-aisle/cool-aisle layout.",answer12);

        HashMap<String,Boolean> answer13 = new HashMap<>();
        answer13.put("paper",true);
        answer13.put("furniture",false);
        answer13.put("ink",false);
        answer13.put("all of  the above",false);
        questions.put("The biggest source of wood consumption is ___________ production.",answer13);

        HashMap<String,Boolean> answer14 = new HashMap<>();
        answer14.put("remote desktop",true);
        answer14.put("desktop server",false);
        answer14.put("desktop client",false);
        answer14.put("none of these",false);
        questions.put("If you buy thin clients, _____________ can be used to connect your thin clients to the server.",answer14);

        HashMap<String,Boolean> answer15 = new HashMap<>();
        answer15.put("CDs & DVDs",true);
        answer15.put("CDs",false);
        answer15.put("DVDs",false);
        answer15.put("None of the above",false);
        questions.put(" ____________ the components can be recycled into everything from automobile parts to office equipment.",answer15);


        return questions;
    }

    public static Map<String,Map<String,Boolean>> getHardQuestions(){HashMap<String,Map<String,Boolean>> questions = new HashMap<>();

        HashMap<String,Boolean> answer1 = new HashMap<>();
        answer1.put("data center density",true);
        answer1.put("storage density",false);
        answer1.put("storage utilization ",false);
        answer1.put("SWaP",false);
        questions.put(" ____________ is a measure of amount of energy consumed per square  feet of floor space. ",answer1);

        HashMap<String,Boolean> answer2 = new HashMap<>();
        answer2.put("Massive Array of Idle Disks ",true);
        answer2.put("Massive Active Indian Disks ",false);
        answer2.put("Mass Array of Idle Disks",false);
        answer2.put("Massive Action Idle Disks",false);
        questions.put("MAID stands for  ",answer2);

        HashMap<String,Boolean> answer3 = new HashMap<>();
        answer3.put("load balancing",false);
        answer3.put("virtualization",true);
        answer3.put("hypervisor",false);
        answer3.put("none of these",false);
        questions.put("Creating more logical IT resources, within one physical system is called ________. ",answer3);

        HashMap<String,Boolean> answer4 = new HashMap<>();
        answer4.put("Flexible and efficient allocation of resources",false);
        answer4.put("Lowers the cost of IT infrastructure",false);
        answer4.put("Remote access and rapid scalability ",false);
        answer4.put("Run on single operating system ",true);
        questions.put("Which is not a benefit of virtualization? ",answer4);

        HashMap<String,Boolean> answer5 = new HashMap<>();
        answer5.put("Energy point",false);
        answer5.put("Energy Star",true);
        answer5.put("Energy check",false);
        answer5.put("Energy score",false);
        questions.put("The EPA's product rating system that assesses the environmental impact of consumer and commercial products is called:",answer5);

        HashMap<String,Boolean> answer6 = new HashMap<>();
        answer6.put("ISO 26000",false);
        answer6.put("ISO 14000",true);
        answer6.put("ISO 9000",false);
        answer6.put("ISO 31000",false);
        questions.put("Which set of standards addresses environmental management systems?",answer6);

        HashMap<String,Boolean> answer7 = new HashMap<>();
        answer7.put("Do not Report the result to stakeholders",true);
        answer7.put("Baseline should be set ",false);
        answer7.put("Deﬁne what all things contribute to carbon footprint",false);
        answer7.put("Track and analyze carbon footprint of organization",false);
        questions.put("Steps to measure  carbon foot printing does not  include",answer7);

        HashMap<String,Boolean> answer8 = new HashMap<>();
        answer8.put("data center density",true);
        answer8.put("SWaP",false);
        answer8.put("Storage density",false);
        answer8.put("storage utilization",false);
        questions.put(" ____________ is a measure of amount of energy consumed per square  feet of ﬂoor space.",answer8);

        HashMap<String,Boolean> answer9 = new HashMap<>();
        answer9.put("storage virtualization",true);
        answer9.put("application virtualization",false);
        answer9.put("Desktop virtualization",false);
        answer9.put("Network virtualization",false);
        questions.put("It is an array of servers that are managed by a virtual storage system.",answer9);

        HashMap<String,Boolean> answer10 = new HashMap<>();
        answer10.put("all of the above",true);
        answer10.put("air pollution",false);
        answer10.put("Water pollution",false);
        answer10.put("Energy usage",false);
        questions.put("Recycling reduces??",answer10);

        HashMap<String,Boolean> answer11 = new HashMap<>();
        answer11.put("all of the above",true);
        answer11.put("LAN",false);
        answer11.put("web server",false);
        answer11.put("web page developer software",false);
        questions.put("Component that is require to build an intranet is?",answer11);

        HashMap<String,Boolean> answer12 = new HashMap<>();
        answer12.put("manufacturing",true);
        answer12.put("corporate performance",false);
        answer12.put("management of end of life product",false);
        answer12.put("packaging attribute",false);
        questions.put("EPEAT does not address which criteria?",answer12);

        HashMap<String,Boolean> answer13 = new HashMap<>();
        answer13.put("lithium",true);
        answer13.put("copper",false);
        answer13.put("barium",false);
        answer13.put("Lead",false);
        questions.put("What is the hazardous pollutant released from telephones?",answer13);

        HashMap<String,Boolean> answer14 = new HashMap<>();
        answer14.put("50",true);
        answer14.put("20",false);
        answer14.put("30",false);
        answer14.put("40",false);
        questions.put("What is the iron and steel constitute of e-waste?",answer14);

        HashMap<String,Boolean> answer15 = new HashMap<>();
        answer15.put("Neon",true);
        answer15.put("Mercury",false);
        answer15.put("cadmium",false);
        answer15.put("Lead",false);
        questions.put("Which toxic compound is not found in e-waste?",answer15);

        return questions;
    }

    public static Map<String,Map<String,Boolean>> getRandomLiteratureAndGeographyQuestions(Context context, String subject, int SIZE){
        Map<String,Map<String,Boolean>> questionsMap = new HashMap<>();
        Map<String, Map<String, Boolean>> originalQuestion;
        if (subject.equals(context.getString(R.string.moderate))){
            originalQuestion = getModerateQuestions();
        }else{
            originalQuestion = getHardQuestions();
        }

        int originalSize =  originalQuestion.size();
        ArrayList<String> keyList = new ArrayList<String>(originalQuestion.keySet());

        while (questionsMap.size()<=SIZE){
            Random random = new Random();
            int randomNumber = random.nextInt(originalSize);
            String question = keyList.get(randomNumber);
            if (!questionsMap.containsKey(question)){
                questionsMap.put(question,originalQuestion.get(question));
            }
        }
        return questionsMap;
    }

}
