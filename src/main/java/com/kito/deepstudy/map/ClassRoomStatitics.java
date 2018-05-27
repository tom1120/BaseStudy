package com.kito.deepstudy.map;/**
 * Created by hasee on 2016/10/26.
 */

import java.util.*;

/**
 * @author zhaoyi
 * @createTime 2016-10-2016/10/26-22:06
 */
public class ClassRoomStatitics {

    public static void main(String[] args) {
        ClassRoomStatitics c
                =new ClassRoomStatitics();
        Map<Integer,ClassRoom> map=c.statitics(c.exam());
        c.view(map);

    }

    /**
     * 查看总分和平均分
     * @param map
     */
    private void view(Map<Integer,ClassRoom> map){
        Set<Integer> integerSet=map.keySet();
        Iterator<Integer> iterator=integerSet.iterator();

        while(iterator.hasNext()){
            Integer classno=iterator.next();
            System.out.println("classno = " + classno);
            ClassRoom room=map.get(classno);
            Integer total=room.getTotalscore();
            System.out.println("total = " + total);
            double avg=total/room.getStudent().size();
            System.out.println("avg = " + avg);

        }

    }



    /**
     *
     * 统计各个班级的考试成绩
     * 按照班级分拣存储
     * 然后统计
     * @param students
     * @return
     */
    public Map<Integer,ClassRoom> statitics(List<Student> students){
        Map<Integer,ClassRoom> map=new HashMap<Integer,ClassRoom>();
        for(Student stu:students){
            Integer classno=stu.getClassno();
            Integer score=stu.getScore();
            ClassRoom room=map.get(classno);
            //班级为空，创建班级
            if(room==null){
                room=new ClassRoom(classno);
                map.put(classno,room);
            }
            //对象存储地址，内容还可以修改
            room.getStudent().add(stu);
            room.setTotalscore(room.getTotalscore()==null?0:room.getTotalscore()+score);
        }
        return map;

    }




    /**
     * 学生考试得出成绩！
     * @return
     */
    public List<Student> exam(){
        List<Student> list=new ArrayList<Student>();
        list.add(new Student(1,"张三",80));
        list.add(new Student(1,"张四",91));
        list.add(new Student(1,"张五",60));
        list.add(new Student(1,"张六",77));
        list.add(new Student(2,"张六",77));
        list.add(new Student(2,"张六",77));
        list.add(new Student(2,"张六",77));
        return list;
    }


}
