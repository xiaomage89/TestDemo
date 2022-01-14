package nc.com.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GoodsDao extends BaseDao{

		
		/**
		 * 查询所有商品信息
		 * @return
		 */
		public List<Map<String,Object>> selectGoods(){
			String sql = "select * from goodstable gs left join goodstype gt on gt.id=gs.goodstype_id order by gs.id";
			Object[] param = null;
			List<Map<String, Object>> list = select(sql, param);
			return list;
			
		}
		
		/**
		 * 查询商品信息
		 * @return
		 */
		public List<Map<String,Object>> condictionSelectGoods(String gname,String goodstypeId){
			StringBuffer sql = new StringBuffer();
			sql.append("select * from goodstable gs left join goodstype gt on gt.id=gs.goodstype_id where 1 = 1 ");
			ArrayList<Object> param = new ArrayList<Object>();
			if(null != gname && gname.trim().length()>0){
				sql.append(" and gs.goodname = ? ");
				param.add(gname);
			}
			if(null != goodstypeId && goodstypeId.trim().length()>0  && !"all".equals(goodstypeId)){
				sql.append(" and gt.id = ? ");
				param.add(goodstypeId);
			}
			sql.append(" order by gs.id ");
			List<Map<String, Object>> list = select(sql.toString(), param.toArray());
			return list;
			
		}
		
		/**
		 * 分页查询所有商品信息
		 * @return
		 */
		public List<Map<String,Object>> selectGoodsByPage(int startindex,int pageCount){
			String sql = "select * from goodstable gs left join goodstype gt on gt.id=gs.goodstype_id order by gs.id ";
			Object[] param = null;
			List<Map<String, Object>> list = select(sql, param);
			return list;
			
		}
		
		/**
		 * 分页查询商品信息
		 * @return
		 */
		public List<Map<String,Object>> condictionSelectGoodsByPage(String gname,String goodstypeId,int startindex,int pageCount){
			StringBuffer sql = new StringBuffer();
			sql.append("select * from goodstable gs left join goodstype gt on gt.id=gs.goodstype_id where 1 = 1 ");
			ArrayList<Object> param = new ArrayList<Object>();
			if(null != gname && gname.trim().length()>0){
				sql.append(" and gs.goodname = ? ");
				param.add(gname);
			}
			if(null != goodstypeId && goodstypeId.trim().length()>0 && !"all".equals(goodstypeId)){
				sql.append(" and gt.id = ? ");
				param.add(goodstypeId);
			}
			sql.append(" order by gs.id ");
			sql.append(" limit ?,? ");
			param.add(startindex);
			param.add(pageCount);

			List<Map<String, Object>> list = select(sql.toString(), param.toArray());
			return list;
			
		}
}
