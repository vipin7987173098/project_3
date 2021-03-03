package in.co.rays.project_3.model;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import in.co.rays.project_3.dto.CourseDTO;
import in.co.rays.project_3.dto.RoleDTO;
import in.co.rays.project_3.dto.StudentDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;
import in.co.rays.project_3.util.HibDataSource;

/**
 * Hibernate implements of Role model
 * @author Mayank mishra
 *
 */
public class RoleModelHibImp implements RoleModelInt{

	public long add(RoleDTO dto) throws ApplicationException, DuplicateRecordException {
		// TODO Auto-generated method stub
		System.out.println("mehto"+dto.getName()+"dsf"+dto.getDescription());
		Session session = null;
		Transaction tx = null;
		long pk = 0;
		System.out.println("hmmmmmmmmmmm");
//		RoleDTO existDto = findByName(dto.getName());
//		System.out.println("role kjkjkjkj"+existDto);
//		if (existDto != null) {
//			throw new DuplicateRecordException("Role already exist");
//		}
		System.out.println("role kjkjkjkj");
		session = HibDataSource.getSession();
		try {
			System.out.println("role asdadas");
			tx = session.beginTransaction();
			session.save(dto);
			System.out.println("save");
			pk = dto.getId();
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			// TODO: handle exception
			if (tx != null) {
				tx.rollback();

			}
			throw new ApplicationException("Exception in Role Add " + e.getMessage());
		} finally {
			session.close();
		}
		return pk;
	}

	public void delete(RoleDTO dto) throws ApplicationException {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		try {
			session = HibDataSource.getSession();
			tx = session.beginTransaction();
			session.delete(dto);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			// TODO: handle exception
			if (tx != null) {
				tx.rollback();

			}
			throw new ApplicationException("Exception in Role delete " + e.getMessage());
		} finally {
			session.close();
		}
	}

	public void update(RoleDTO dto) throws ApplicationException, DuplicateRecordException {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		try {
			session = HibDataSource.getSession();
			tx = session.beginTransaction();
			session.update(dto);
			tx.commit();

		} catch (HibernateException e) {
			e.printStackTrace();
			// TODO: handle exception
			if (tx != null) {
				tx.rollback();

			}
			throw new ApplicationException("Exception in Role update " + e.getMessage());
		} finally {
			session.close();
		}

	}

	public List list() throws ApplicationException {
		// TODO Auto-generated method stub
		return list(0,0);
	}

	public List list(int pageNo, int pageSize) throws ApplicationException {
		// TODO Auto-generated method stub
		Session session = null;
		List list = null;
		try {
			session = HibDataSource.getSession();
			Criteria criteria = session.createCriteria(RoleDTO.class);
			if (pageSize > 0) {
				pageNo = ((pageNo - 1) * pageSize) + 1;
				criteria.setFirstResult(pageNo);
				criteria.setMaxResults(pageSize);
			}
			list = criteria.list();
		} catch (HibernateException e) {

			throw new ApplicationException("Exception : Exception in  role list");
		} finally {
			session.close();
		}
		return list;
	}

	public List search(RoleDTO dto) throws ApplicationException {
		// TODO Auto-generated method stub
		return search(dto,0,0);
	}

	public List search(RoleDTO dto, int pageNo, int pageSize) throws ApplicationException {
		// TODO Auto-generated method stub
		Session session=null;
		List list=null;
		try {
			session=HibDataSource.getSession();
			Criteria criteria=session.createCriteria(RoleDTO.class);
			if(dto.getId()>0){
				criteria.add(Restrictions.eq("id", dto.getId()));
			}
			if(dto.getName()!=null&& dto.getName().length()>0){
				criteria.add(Restrictions.like("name", dto.getName()+"%"));
			}
			if(dto.getDescription()!=null&& dto.getDescription().length()>0){
				criteria.add(Restrictions.like("description", dto.getDescription()+"%"));
			}
			if(pageSize>0){
				criteria.setFirstResult((pageNo-1)*pageSize);
				criteria.setMaxResults(pageSize);
			}
			list=criteria.list();
		} catch (HibernateException e) {
            
            throw new ApplicationException("Exception in course search");
        } finally {
            session.close();
        }
		return list;
	}

	public RoleDTO findByPK(long pk) throws ApplicationException {
		// TODO Auto-generated method stub
		Session session = HibDataSource.getSession();
		
		System.out.println(" Hibernate FindByPK Run"+ pk);
		try {
			RoleDTO dto = (RoleDTO) session.get(RoleDTO.class, pk);
			System.out.println(dto+"-----??????????????????????????????");
			return dto;
		} catch (HibernateException e) {

			throw new ApplicationException("Exception : Exception in getting Role by pk");
		} finally {
			session.close();
		}
		
	}

	public RoleDTO findByName(String name) throws ApplicationException {
		// TODO Auto-generated method stub
		Session session = null;
		RoleDTO dto = null;
		try {
			session = HibDataSource.getSession();
			Criteria criteria = session.createCriteria(RoleDTO.class);
			criteria.add(Restrictions.eq("name", name));
			List list = criteria.list();
			if (list.size() > 0) {
				dto = (RoleDTO) list.get(0);
			}
		} catch (HibernateException e) {

			throw new ApplicationException("Exception in getting Role by Login " + e.getMessage());

		} finally {
			session.close();
		}
		return dto;
	}

}
