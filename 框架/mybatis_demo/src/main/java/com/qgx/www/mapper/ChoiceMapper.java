package com.qgx.www.mapper;

import com.qgx.www.entity.Choice;

import java.util.List;

public interface ChoiceMapper {

    /**
     * 测试查所有
     * 该处的方法要和ChoiceMapper.xml中的select的id一致
     * @return
     */
    public List<Choice> findAll();

    /**
     * 测试带1个参数查询
     *该处的方法要和ChoiceMapper.xml中的select的id一致,且参数要和sql中的占位符一致
     * @param id
     * @return
     */
    public List<Choice> findChoiceById(int id);

    /**
     * 测试带多个参数查询
     *该处的方法要和ChoiceMapper.xml中的select的id一致,且参数要和sql中的占位符一致
     * @param choice
     * @return
     */
    public List<Choice> findChoiceByIdAndTitle(Choice choice);

    /**
     * 测试增加
     * @param choice
     * @return
     */
    public int addChoice(Choice choice);

    /**
     * 测试删除
     * @param id
     * @return
     */
    public int delChoiceById(int id);

    /**
     * 测试修改
     * @param choice
     * @return
     */
    public int updateChoiceById(Choice choice);
}
