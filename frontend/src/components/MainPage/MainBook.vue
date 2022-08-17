<template>
	<div>
		<v-row class="pa-0 ma-0" rounded>
			<v-col cols="12" class="pa-0">
				<main-book-items
					v-for="(MainBook, idx) in MainBooks"
					:key="idx"
					:MainBook="MainBook"
				></main-book-items>
				<v-pagination
					v-model="nowPage"
					:length="endPage"
					color="#A384FF"
					circle
					@input="handlePage()"
				></v-pagination>
			</v-col>
		</v-row>
	</div>
</template>

<script>
import axios from 'axios';
import drf from '@/api/drf';
import MainBookItems from '@/components/MainPage/MainBookItems.vue';
import { mapGetters } from 'vuex';

export default {
	data() {
		return {
			totalInfos: [],
			MainBooks: [],
			nowPage: 1,
			endPage: 0,
			page: 0,
		};
	},
	components: {
		MainBookItems,
	},
	computed: {
		...mapGetters(['accessToken'])
	},
	created() {
		// 0810 오채명 : 밑에 코드 절때로 건들이지 말기
		// 페이지 렌더링 될 때 첫번 째 엑시오스
		const params = {
			page: 0,
			size: 5,
			sort: 'updated,DESC',
		};
		axios({
			// 0808 오채명 : 모든 게시글, 문제 가져올 때 확인하려고 위의 주소로 했는데, 밑에꺼로 해야함
			url: drf.api + 'post' + '/workbook',
			method: 'get',
			headers: {
				Authorization: this.accessToken,
			},
			params: params,
		})
			.then((res) => {
				this.MainBooks = res.data.content;
				console.log('MainBooks = ', this.MainBooks);
				// console.log(res.data.totalPages)
				this.endPage = res.data.totalPages;
			})
			.catch((err) => {
				console.log('에러');
				console.log(err);
			});
	},
	methods: {
		handlePage() {
			console.log('event = ', Number(event.target.ariaLabel.slice(-1)));
			this.page = Number(event.target.ariaLabel.slice(-1));

			const params = {
				page: this.page - 1,
				size: 5,
				sort: 'updated,DESC',
			};
			axios({
				url: drf.api + 'post' + '/workbook',
				method: 'get',
				headers: {
					Authorization: this.accessToken,
				},
				params: params,
			})
				.then((res) => {
					console.log('넘어온 data = ', res.data.content);
					this.MainBooks = res.data.content;
					console.log('현재 data =', this.MainBooks);
				})
				.catch((err) => {
					console.log('에러');
					console.log(err);
				});
		},
	},
};
</script>

<style scoped></style>
