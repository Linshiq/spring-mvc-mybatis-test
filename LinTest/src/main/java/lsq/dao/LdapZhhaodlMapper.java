package lsq.dao;

import lsq.model.LdapZhhaodl;

public interface LdapZhhaodlMapper {
    int deleteByPrimaryKey(String id);

    int insert(LdapZhhaodl record);

    int insertSelective(LdapZhhaodl record);

    LdapZhhaodl selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(LdapZhhaodl record);

    int updateByPrimaryKey(LdapZhhaodl record);
}