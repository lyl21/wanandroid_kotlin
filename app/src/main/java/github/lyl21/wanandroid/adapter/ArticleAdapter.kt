package github.lyl21.wanandroid.adapter

import android.text.Html
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.chad.library.adapter.base.module.LoadMoreModule
import github.lyl21.wanandroid.R
import github.lyl21.wanandroid.databinding.ItemArticleBinding
import github.lyl21.wanandroid.entity.ArticleDetail

/**
 *
 *
 * @author    popcomimico
 * @date    2021/9/29 17:05
 */
class ArticleAdapter :
    BaseBindingQuickAdapter<ArticleDetail, ItemArticleBinding>(R.layout.item_article),
    LoadMoreModule {

//    private var imgLists: MutableList<Int>

    init {
        addChildClickViewIds(R.id.iv_home_article_like)
        addChildClickViewIds(R.id.iv_home_article_download)
//        imgLists = mutableListOf(
//            R.mipmap.list_1,
//            R.mipmap.list_2,
//            R.mipmap.list_3,
//            R.mipmap.list_4,
//            R.mipmap.list_5,
//            R.mipmap.list_6,
//            R.mipmap.list_7,
//            R.mipmap.list_8,
//            R.mipmap.list_9,
//            R.mipmap.list_10,
//        )
    }


    override fun convert(holder: BaseBindingHolder, item: ArticleDetail) {


        Glide.with(context)
//            .load(imgLists[(0..9).random()])
            .load(R.mipmap.ic_launcher_round)
            .apply( RequestOptions()
                .transform( CenterCrop(),  RoundedCorners(15)
                ))
            .into(holder.getView(R.id.iv_home_article))


        holder.setText(R.id.tv_home_article_title, Html.fromHtml(item.title))
        holder.setText(R.id.tv_home_article_tag, item.chapterName)

        if ( item.niceDate.contains("-")){
            val length = item.niceDate.length
            holder.setText(R.id.tv_home_article_time,  item.niceDate.substring(0, length-5 ))
        }else{
            holder.setText(R.id.tv_home_article_time,item.niceDate)
        }



        if (item.collect) {
            Glide.with(context)
                .load(R.mipmap.like_checked)
                .into(holder.getView(R.id.iv_home_article_like))
        } else {
            Glide.with(context)
                .load(R.mipmap.like_normal)
                .into(holder.getView(R.id.iv_home_article_like))
        }
    }
}