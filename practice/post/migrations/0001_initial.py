# -*- coding: utf-8 -*-
# Generated by Django 1.9.4 on 2016-06-27 07:05
from __future__ import unicode_literals

from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    initial = True

    dependencies = [
        ('user_groups', '0003_auto_20160601_1719'),
    ]

    operations = [
        migrations.CreateModel(
            name='Post',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('title', models.CharField(max_length=120)),
                ('content', models.TextField(blank=True)),
                ('image', models.FileField(blank=True, null=True, upload_to='')),
                ('institute', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, to='user_groups.Institute')),
                ('user', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, related_name='post_owner', to='user_groups.UserDetail')),
            ],
        ),
    ]
