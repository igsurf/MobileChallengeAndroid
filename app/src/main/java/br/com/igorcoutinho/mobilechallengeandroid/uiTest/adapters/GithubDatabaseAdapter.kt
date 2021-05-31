package br.com.igorcoutinho.mobilechallengeandroid.uiTest.adapters

import android.content.Context
import br.com.igorcoutinho.mobilechallengeandroid.data.GithubRepository
import br.com.igorcoutinho.mobilechallengeandroid.utils.Constants
import com.couchbase.lite.*
import kotlin.RuntimeException


class GithubDatabaseAdapter(private val context: Context) {
    fun saveGithubRepositories(githubRepositoryList:  MutableList<GithubRepository>) {
        try {
            val config = DatabaseConfiguration(context)
            val database = Database(Constants.DATABASE_NAME, config)

            database.inBatch {
                for (item in githubRepositoryList) {
                    val doc = MutableDocument()
                    doc.setValue("id", item.id)
                    doc.setValue("name", item.name)
                    doc.setValue("description", item.description)
                    doc.setValue("stargazersCount", item.stargazersCount)
                    doc.setValue("forksCount", item.forksCount)

                    try {
                        database.save(doc)
                    } catch (e: CouchbaseLiteException) {
                        //Log.e(TAG, e.toString())
                        throw Exception("Erro ao salvar os dados no banco: ${e.message}")
                    }
                }

            }
        }catch (ex: Exception) {
            throw  ex
        }
    }

    fun getAllGithubRepositories(page: Int): MutableList<GithubRepository> {
        val limit = 30
        val offset = (page - 1) * limit
        try {

            val result = getLimitData(limit, offset)

            return transformationResultToGithubRepository(result)

        } catch (ex: java.lang.Exception) {
            throw ex
        }
    }

    fun getLimitData(limit: Int, offset: Int): ResultSet {
        if( limit < 0 || offset < 0){
            throw RuntimeException()
        }
        val config = DatabaseConfiguration(context)
        val db = Database(Constants.DATABASE_NAME, config)

        val query: Query = QueryBuilder.select(SelectResult.all())
            .from(DataSource.database(db))
            .limit(Expression.intValue(limit), Expression.intValue(offset))

        return query.execute();
    }

    fun transformationResultToGithubRepository(result: ResultSet) : MutableList<GithubRepository> {

        val listResult = mutableListOf<GithubRepository>()

        for (item in result) {
            val all: Dictionary = item.getDictionary(Constants.DATABASE_NAME)

            listResult.add(
                GithubRepository(
                    id = all.getLong("id"),
                    name = all.getString("name"),
                    description = all.getString("description"),
                    stargazersCount = all.getLong("stargazersCount"),
                    forksCount = all.getLong("forksCount"),
                    githubRepositoryOwner = null
                )
            )
        }

        return listResult
    }
}